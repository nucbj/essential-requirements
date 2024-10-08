package io.task.estl.rqmt.corekit.repositories;

import io.task.estl.rqmt.corekit.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

  Users findByName(String name);
}
