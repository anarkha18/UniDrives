package com.unidrives.repos;


import com.unidrives.entitys.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends JpaRepository<University, Integer> {

     boolean existsByUniversityId(String universityId);
}
