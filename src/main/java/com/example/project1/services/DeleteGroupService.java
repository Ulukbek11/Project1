package com.example.project1.services;

import com.example.project1.repositories.GroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteGroupService {

    private final GroupRepository groupRepository;

    public DeleteGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public ResponseEntity<String> execute(Long groupId) {
        if (groupRepository.findById(groupId).isPresent()) {
            groupRepository.deleteById(groupId);
            return ResponseEntity.status(HttpStatus.OK).body("Успешно удален");
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Группы не существует");
    }
}
