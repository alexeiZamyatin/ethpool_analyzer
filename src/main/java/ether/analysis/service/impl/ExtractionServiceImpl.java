package ether.analysis.service.impl;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import ether.analysis.EthpoolExtractorApplication;
import ether.analysis.http.EthpoolRequestService;
import ether.analysis.model.MinerCreditInfo;
import ether.analysis.service.ExctractionService;
import ether.analysis.service.MinerCreditInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static ether.analysis.EthpoolExtractorApplication.metricRegistry;

@Service
public class ExtractionServiceImpl implements ExctractionService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EthpoolRequestService ethpoolRequestService;

    @Autowired
    private MinerCreditInfoService minerCreditInfoService;

    private Timer creditsRequestTimer = metricRegistry.timer("credit-requests:");
    private Timer dbPersistTimer = metricRegistry.timer("database-create-queries:");

    public void extractCredits() {
        logger.info("Extracting credits");

        // Performance metrics for http requests
        final Timer.Context creditsRequestContext = creditsRequestTimer.time();

        List<MinerCreditInfo> minerCreditInfoList = ethpoolRequestService.getCredits();

        creditsRequestContext.stop();

        long topMinerCredit = 0L;
        long extractionTimestamp = System.currentTimeMillis();

        for (MinerCreditInfo minerCreditInfo : minerCreditInfoList) {

            int index = minerCreditInfoList.indexOf(minerCreditInfo);
            if(index == 0){
                topMinerCredit = minerCreditInfo.getCredit();
            }

            minerCreditInfo.setRank(index+1);
            minerCreditInfo.setTimestamp(extractionTimestamp);

            //seconds
            minerCreditInfo.setErstimatedTtnb(((topMinerCredit - minerCreditInfo.getCredit())/minerCreditInfo.getHashrate())/60);

            // Performance metrics for database queries
            final Timer.Context dbPersistContext = dbPersistTimer.time();

            minerCreditInfoService.create(minerCreditInfo);

            dbPersistContext.stop();

        }
    }
}
