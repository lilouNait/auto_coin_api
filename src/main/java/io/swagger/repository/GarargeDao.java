package io.swagger.repository;

import io.swagger.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GarargeDao extends JpaRepository<Garage,Integer>, JpaSpecificationExecutor<Garage> {

}
