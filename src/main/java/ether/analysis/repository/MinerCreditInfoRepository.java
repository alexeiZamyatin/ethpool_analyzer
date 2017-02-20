package ether.analysis.repository;

import ether.analysis.model.MinerCreditInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alexei on 19.02.17.
 */
public interface MinerCreditInfoRepository extends JpaRepository<MinerCreditInfo, Long> {
}
