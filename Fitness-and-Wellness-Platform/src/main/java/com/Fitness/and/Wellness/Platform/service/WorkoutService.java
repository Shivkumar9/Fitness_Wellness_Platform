package com.Fitness.and.Wellness.Platform.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fitness.and.Wellness.Platform.dto.WorkoutDto;
import com.Fitness.and.Wellness.Platform.model.Workout;
import com.Fitness.and.Wellness.Platform.repository.WorkoutRepository;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<WorkoutDto> getAllWorkouts() {
        return workoutRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<WorkoutDto> getWorkoutById(Long id) {
        return workoutRepository.findById(id).map(this::convertToDto);
    }

    public WorkoutDto createWorkout(WorkoutDto workoutDto) {
        Workout workout = convertToEntity(workoutDto);
        workout = workoutRepository.save(workout);
        return convertToDto(workout);
    }

    public Optional<WorkoutDto> updateWorkout(Long id, WorkoutDto workoutDto) {
        return workoutRepository.findById(id).map(existingWorkout -> {
            existingWorkout.setName(workoutDto.getName());
            existingWorkout.setDescription(workoutDto.getDescription());
            existingWorkout.setDate(workoutDto.getDate());
            Workout updatedWorkout = workoutRepository.save(existingWorkout);
            return convertToDto(updatedWorkout);
        });
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }

    private WorkoutDto convertToDto(Workout workout) {
        WorkoutDto workoutDto = new WorkoutDto();
        workoutDto.setId(workout.getId());
        workoutDto.setName(workout.getName());
        workoutDto.setDescription(workout.getDescription());
        workoutDto.setDate(workout.getDate());
        workoutDto.setUserId(workout.getUser().getId());
        return workoutDto;
    }

    private Workout convertToEntity(WorkoutDto workoutDto) {
        Workout workout = new Workout();
        workout.setName(workoutDto.getName());
        workout.setDescription(workoutDto.getDescription());
        workout.setDate(workoutDto.getDate());
        return workout;
    }
}
