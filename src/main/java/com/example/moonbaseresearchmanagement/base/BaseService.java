package com.example.moonbaseresearchmanagement.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class BaseService {
    
    private final BaseRepository baseRepository;

    @Autowired
    public BaseService(BaseRepository baseRepository){
        this.baseRepository = baseRepository;
    }

    public List<Base> getAllBases(){
        return baseRepository.findAll();
    }

    public void addNewBase(Base base){
        Optional<Base> baseById = baseRepository.findById(base.getBaseID());
        if(baseById.isPresent()){
            throw new IllegalStateException("Base already exists");
        }
        baseRepository.save(base);
    }

    public Base getBaseById(long baseId){
        Optional<Base> baseById = baseRepository.findById(baseId);
        if(!baseById.isPresent()){
            throw new IllegalStateException("Base does not exist");
        }
        return baseById.get();
    }
}
