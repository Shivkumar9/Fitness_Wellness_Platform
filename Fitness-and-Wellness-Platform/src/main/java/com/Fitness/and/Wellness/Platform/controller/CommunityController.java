package com.Fitness.and.Wellness.Platform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Fitness.and.Wellness.Platform.dto.CommunityDto;
import com.Fitness.and.Wellness.Platform.service.CommunityService;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping
    public List<CommunityDto> getAllCommunities() {
        return communityService.getAllCommunities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CommunityDto>> getCommunityById(@PathVariable Long id) {
        return ResponseEntity.ok(communityService.getCommunityById(id));
    }

    @PostMapping
    public ResponseEntity<CommunityDto> createCommunity(@RequestBody CommunityDto communityDto) {
        return ResponseEntity.ok(communityService.createCommunity(communityDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<CommunityDto>> updateCommunity(@PathVariable Long id, @RequestBody CommunityDto communityDto) {
        return ResponseEntity.ok(communityService.updateCommunity(id, communityDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
        communityService.deleteCommunity(id);
        return ResponseEntity.noContent().build();
    }
}