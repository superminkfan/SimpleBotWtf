package com.web.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<RecordEntity, Long> {
    List<RecordEntity> findAllByUsernameContaining(String name);

}
