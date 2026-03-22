package com.bank.app.repository;

import com.bank.app.model.AppModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<AppModel,Long> {

}
