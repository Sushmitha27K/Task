package com.example.Data.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Data.entity.DataEntity;
import com.example.Data.repository.DataRepository;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public List<DataEntity> getAllData() {
        return dataRepository.findAll();
    }
}
