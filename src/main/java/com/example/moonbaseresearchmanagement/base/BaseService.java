package com.example.moonbaseresearchmanagement.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    private final BaseRepository baseRepository;

    @Autowired
    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<Base> getAllBases() {
        return baseRepository.findAll();
    }

    public void addNewBase(Base base) {
        Optional<Base> baseById = baseRepository.findBaseByBaseId(base.getBaseID());
        if (baseById.isPresent()) {
            throw new IllegalStateException("Base already exists");
        }
        baseRepository.save(base);
    }

    public Base getBaseById(int baseId) {
        Optional<Base> baseById = baseRepository.findBaseByBaseId(baseId);
        if (!baseById.isPresent()) {
            throw new IllegalStateException("Base does not exist");
        }
        return baseById.get();
    }
}
