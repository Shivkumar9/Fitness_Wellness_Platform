package com.Fitness.and.Wellness.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fitness.and.Wellness.Platform.model.Nutrition;

@Repository
public interface NutritionRepository extends JpaRepository<Nutrition, Long>{

}
