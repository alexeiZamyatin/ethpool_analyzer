package ether.analysis.thread;

import ether.analysis.model.MinerCreditInfo;
import ether.analysis.http.EthpoolRequestService;
import ether.analysis.service.MinerCreditInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexei on 19.02.17.
 */
@Service
public class ExtractionThread implements Runnable {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EthpoolRequestService ethpoolRequestService;

    @Autowired
    private  MinerCreditInfoService minerCreditInfoService;

    @Override
    public void run() {

        logger.info("Extracting credits");
        List<MinerCreditInfo> minerCreditInfoList = ethpoolRequestService.getCredits();

        long topMinerCredit = 0L;
        for (MinerCreditInfo minerCreditInfo : minerCreditInfoList) {

            int index = minerCreditInfoList.indexOf(minerCreditInfo);
            if(index == 0){
                topMinerCredit = minerCreditInfo.getCredit();
            }

            minerCreditInfo.setRank(index+1);

            //seconds
            minerCreditInfo.setErstimatedTtnb(((topMinerCredit - minerCreditInfo.getCredit())/minerCreditInfo.getHashrate())/60);

            minerCreditInfoService.create(minerCreditInfo);

        }

        logger.info("Persisted credits");

        logger.info("Extracting luck");

        
        logger.info("Persisted luck");




        /**
         * text: moment.duration(($root.topMinerCredit() - credit) / hashrate, 'seconds').humanize(true)
         */
    }
}
