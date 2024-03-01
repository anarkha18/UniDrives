package com.unidrives.services;

import com.unidrives.entitys.University;
import com.unidrives.excephandlers.GlobalExceptionHandler;
import com.unidrives.repos.UniversityRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UniversityService {
    private static final Logger logger = LoggerFactory.getLogger(UniversityService.class);

    @Autowired
    private UniversityRepo universityRepo;

    public void addOrUpdateUniversity(University university) throws Exception{
        universityRepo.save(university);
        logger.info(university + "saved to database");
    }

    public boolean alreadyExists(String universityId)  throws Exception{
        if(universityRepo.existsByUniversityId(universityId)){
            logger.error("University already exists");
            return true;
        }
        return false;
    }
}
