package io.task.estl.rqmt.corekit.repositories;

import io.task.estl.rqmt.corekit.entities.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {

  List<PointHistory> findAllByUserId(Long userId);
}
