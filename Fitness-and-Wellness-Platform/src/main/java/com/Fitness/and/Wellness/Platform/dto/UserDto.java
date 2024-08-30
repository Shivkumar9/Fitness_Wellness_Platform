package com.Fitness.and.Wellness.Platform.dto;

import java.util.Set;

public class UserDto {

	private Long id;
	private String username;
	private String email;
	private String password;
	private Set<Long> workoutIds;
	private Set<Long> nutritionPlanIds;
	private Set<Long> communityIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Long> getWorkoutIds() {
		return workoutIds;
	}

	public void setWorkoutIds(Set<Long> workoutIds) {
		this.workoutIds = workoutIds;
	}

	public Set<Long> getNutritionPlanIds() {
		return nutritionPlanIds;
	}

	public void setNutritionPlanIds(Set<Long> nutritionPlanIds) {
		this.nutritionPlanIds = nutritionPlanIds;
	}

	public Set<Long> getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(Set<Long> communityIds) {
		this.communityIds = communityIds;
	}

}
