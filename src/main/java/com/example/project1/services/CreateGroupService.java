package com.example.project1.services;
import com.example.project1.models.Group;
import com.example.project1.repositories.GroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreateGroupService {

    private final GroupRepository groupRepository;

    public CreateGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public ResponseEntity<Group> execute(Group group) {
        if(group.getGroupId() == null
                && group.getGroupName() != null
                && group.getGroupName() != null
                && group.getYear() != null
                && group.getDepartment() != null) {
            groupRepository.save(group);
            return ResponseEntity.status(HttpStatus.CREATED).body(group);
        }
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нужны все параметры");
    }
}
