package com.example.project1.services;

import com.example.project1.models.Group;
import com.example.project1.repositories.GroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetGroupService {

    private final GroupRepository groupRepository;

    public GetGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group execute(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + groupId));
    }
}
