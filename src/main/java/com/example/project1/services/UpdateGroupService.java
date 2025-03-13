package com.example.project1.services;

import com.example.project1.models.Group;
import com.example.project1.models.Student;
import com.example.project1.repositories.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UpdateGroupService {

    private final GroupRepository groupRepository;

    public UpdateGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public ResponseEntity<Group> execute(Long groupId, Group newGroup) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found with id: " + groupId));

        if(newGroup.getGroupName() != null &&
        newGroup.getGroupName().length() > 0 &&
        !Objects.equals(newGroup.getGroupName(), group.getGroupName())){
            group.setGroupName(newGroup.getGroupName());
        }

        if(newGroup.getDepartment() != null &&
                newGroup.getDepartment().length() > 0 &&
                !Objects.equals(newGroup.getDepartment(), group.getDepartment())){
            group.setDepartment(newGroup.getDepartment());
        }

        if(newGroup.getYear() != null &&
                newGroup.getYear() > 0 &&
                newGroup.getYear() < 4){
            group.setYear(newGroup.getYear());
        }

        groupRepository.save(group);

        return ResponseEntity.status(HttpStatus.OK).body(group);


    }
}
