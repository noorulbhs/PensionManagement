package com.fse0.microservice.processpension.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionerDetailRepositoryManager extends JpaRepository<PensionerDetailRepo,Integer> {


}
