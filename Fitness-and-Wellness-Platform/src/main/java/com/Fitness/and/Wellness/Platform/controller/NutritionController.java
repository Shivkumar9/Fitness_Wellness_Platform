package com.Fitness.and.Wellness.Platform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Fitness.and.Wellness.Platform.dto.NutritionDto;
import com.Fitness.and.Wellness.Platform.service.NutritionService;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;

    @GetMapping
    public List<NutritionDto> getAllNutritionPlans() {
        return nutritionService.getAllNutritionPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NutritionDto>> getNutritionById(@PathVariable Long id) {
        return ResponseEntity.ok(nutritionService.getNutritionById(id));
    }

    @PostMapping
    public ResponseEntity<NutritionDto> createNutrition(@RequestBody NutritionDto nutritionDto) {
        return ResponseEntity.ok(nutritionService.createNutrition(nutritionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<NutritionDto>> updateNutrition(@PathVariable Long id, @RequestBody NutritionDto nutritionDto) {
        return ResponseEntity.ok(nutritionService.updateNutrition(id, nutritionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutrition(@PathVariable Long id) {
        nutritionService.deleteNutrition(id);
        return ResponseEntity.noContent().build();
    }
}
