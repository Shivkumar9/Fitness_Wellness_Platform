package com.Fitness.and.Wellness.Platform.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fitness.and.Wellness.Platform.dto.CommunityDto;
import com.Fitness.and.Wellness.Platform.model.Community;
import com.Fitness.and.Wellness.Platform.repository.CommunityRepository;

@Service
public class CommunityService {

	@Autowired
	private CommunityRepository communityRepository;
	
	public List<CommunityDto> getAllCommunities() {
        return communityRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<CommunityDto> getCommunityById(Long id) {
        return communityRepository.findById(id).map(this::convertToDto);
    }

    public CommunityDto createCommunity(CommunityDto communityDto) {
        Community community = convertToEntity(communityDto);
        community = communityRepository.save(community);
        return convertToDto(community);
    }

    public Optional<CommunityDto> updateCommunity(Long id, CommunityDto communityDto) {
        return communityRepository.findById(id).map(existingCommunity -> {
            existingCommunity.setName(communityDto.getName());
            existingCommunity.setDescription(communityDto.getDescription());
            Community updatedCommunity = communityRepository.save(existingCommunity);
            return convertToDto(updatedCommunity);
        });
    }

    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }

    private CommunityDto convertToDto(Community community) {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setId(community.getId());
        communityDto.setName(community.getName());
        communityDto.setDescription(community.getDescription());
        communityDto.setUserId(community.getUser().getId());
        return communityDto;
    }

    private Community convertToEntity(CommunityDto communityDto) {
        Community community = new Community();
        community.setName(communityDto.getName());
        community.setDescription(communityDto.getDescription());
        return community;
    }
}
