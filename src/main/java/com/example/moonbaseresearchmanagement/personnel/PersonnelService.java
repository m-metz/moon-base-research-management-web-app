package com.example.moonbaseresearchmanagement.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }
    
}
