package com.example.Data.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Data.entity.DataEntity;


public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
