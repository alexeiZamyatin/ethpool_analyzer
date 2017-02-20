package ether.analysis.service;

import ether.analysis.model.MinerCreditInfo;

import java.util.List;

/**
 * Created by alexei on 19.02.17.
 */
public interface MinerCreditInfoService {

    MinerCreditInfo create(MinerCreditInfo minerCreditInfo);

    List<MinerCreditInfo> readAll();
}
