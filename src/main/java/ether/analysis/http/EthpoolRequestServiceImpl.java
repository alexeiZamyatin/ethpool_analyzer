package ether.analysis.http;

import ether.analysis.model.MinerCreditInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EthpoolRequestServiceImpl implements EthpoolRequestService {


    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Value("${rest.url}")
    protected String url;

    private RestTemplate restTemplate;

    public EthpoolRequestServiceImpl() {
        this.restTemplate = new RestTemplate();
    }


    @Override
    public List<MinerCreditInfo> getCredits() {

        String restUrl = url + "/credits";

        List<MinerCreditInfo> minerCreditInfos = Arrays.asList(restTemplate.getForObject(restUrl, MinerCreditInfo[].class));

        return minerCreditInfos;
    }
}
