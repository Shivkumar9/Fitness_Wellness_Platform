package com.Fitness.and.Wellness.Platform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Fitness.and.Wellness.Platform.dto.WorkoutDto;
import com.Fitness.and.Wellness.Platform.service.WorkoutService;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping
    public List<WorkoutDto> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkoutDto>> getWorkoutById(@PathVariable Long id) {
        return ResponseEntity.ok(workoutService.getWorkoutById(id));
    }

    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@RequestBody WorkoutDto workoutDto) {
        return ResponseEntity.ok(workoutService.createWorkout(workoutDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<WorkoutDto>> updateWorkout(@PathVariable Long id, @RequestBody WorkoutDto workoutDto) {
        return ResponseEntity.ok(workoutService.updateWorkout(id, workoutDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
