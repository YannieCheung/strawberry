package edu.zipcloud.cloudstreetmarket.core.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.zipcloud.cloudstreetmarket.core.dtos.UserActivityDTO;

public interface ICommunityService {
	Page<UserActivityDTO> getPublicActivity(Pageable pageable);
	List<UserActivityDTO> getLastUserPublicActivity(int number);
}
