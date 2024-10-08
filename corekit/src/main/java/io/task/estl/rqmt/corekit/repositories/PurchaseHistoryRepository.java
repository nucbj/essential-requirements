package io.task.estl.rqmt.corekit.repositories;

import io.task.estl.rqmt.corekit.entities.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

  List<PurchaseHistory> findAllByUserId(Long userId);
}
