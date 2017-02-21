package ether.analysis.service.impl;

import ether.analysis.model.MinerCreditInfo;
import ether.analysis.repository.MinerCreditInfoRepository;
import ether.analysis.service.MinerCreditInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexei on 19.02.17.
 */
@Service
public class MinerCreditServiceImpl implements MinerCreditInfoService {

    @Autowired
    private MinerCreditInfoRepository repository;

    @Override
    @Transactional
    public MinerCreditInfo create(MinerCreditInfo minerCreditInfo) {
        return repository.save(minerCreditInfo);
    }

    @Override
    public List<MinerCreditInfo> readAll() {
        return repository.findAll();
    }
}
