package com.Fitness.and.Wellness.Platform.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fitness.and.Wellness.Platform.dto.NutritionDto;
import com.Fitness.and.Wellness.Platform.model.Nutrition;
import com.Fitness.and.Wellness.Platform.repository.NutritionRepository;

@Service
public class NutritionService {

    @Autowired
    private NutritionRepository nutritionRepository;

    public List<NutritionDto> getAllNutritionPlans() {
        return nutritionRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<NutritionDto> getNutritionById(Long id) {
        return nutritionRepository.findById(id).map(this::convertToDto);
    }

    public NutritionDto createNutrition(NutritionDto nutritionDto) {
        Nutrition nutrition = convertToEntity(nutritionDto);
        nutrition = nutritionRepository.save(nutrition);
        return convertToDto(nutrition);
    }

    public Optional<NutritionDto> updateNutrition(Long id, NutritionDto nutritionDto) {
        return nutritionRepository.findById(id).map(existingNutrition -> {
            existingNutrition.setMealPlan(nutritionDto.getMealPlan());
            existingNutrition.setCalories(nutritionDto.getCalories());
            Nutrition updatedNutrition = nutritionRepository.save(existingNutrition);
            return convertToDto(updatedNutrition);
        });
    }

    public void deleteNutrition(Long id) {
        nutritionRepository.deleteById(id);
    }

    private NutritionDto convertToDto(Nutrition nutrition) {
        NutritionDto nutritionDto = new NutritionDto();
        nutritionDto.setId(nutrition.getId());
        nutritionDto.setMealPlan(nutrition.getMealPlan());
        nutritionDto.setCalories(nutrition.getCalories());
        nutritionDto.setUserId(nutrition.getUser().getId());
        return nutritionDto;
    }

    private Nutrition convertToEntity(NutritionDto nutritionDto) {
        Nutrition nutrition = new Nutrition();
        nutrition.setMealPlan(nutritionDto.getMealPlan());
        nutrition.setCalories(nutritionDto.getCalories());
        return nutrition;
    }
}
