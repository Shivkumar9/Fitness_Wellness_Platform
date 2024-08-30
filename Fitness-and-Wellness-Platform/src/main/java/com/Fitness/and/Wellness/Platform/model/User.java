package com.Fitness.and.Wellness.Platform.model;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String email;

	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Workout> workouts;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Nutrition> nutritionPlans;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Community> communities;

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

	public Set<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(Set<Workout> workouts) {
		this.workouts = workouts;
	}

	public Set<Nutrition> getNutritionPlans() {
		return nutritionPlans;
	}

	public void setNutritionPlans(Set<Nutrition> nutritionPlans) {
		this.nutritionPlans = nutritionPlans;
	}

	public Set<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(Set<Community> communities) {
		this.communities = communities;
	}
}
