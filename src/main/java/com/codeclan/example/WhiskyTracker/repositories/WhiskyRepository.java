package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByYear(int year);

    List<Whisky> findByDistilleryId(Long id);
    List<Whisky> findByDistilleryIdAndAge(Long id, int age);
}
