package ether.analysis.http;

import ether.analysis.model.MinerCreditInfo;

import java.util.List;

/**
 * Created by alexei on 19.02.17.
 */
public interface EthpoolRequestService {


    List<MinerCreditInfo> getCredits();
}
