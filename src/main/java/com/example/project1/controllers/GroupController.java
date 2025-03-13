package com.example.project1.controllers;

import com.example.project1.models.Group;
import com.example.project1.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final CreateGroupService createGroupService;
    private final GetGroupService getGroupService;
    private final UpdateGroupService updateGroupService;
    private final DeleteGroupService deleteGroupService;
    public GroupController(CreateGroupService createGroupService,
                           GetGroupService getGroupService,
                           UpdateGroupService updateGroupService,
                           DeleteGroupService deleteGroupService) {
        this.createGroupService = createGroupService;
        this.getGroupService = getGroupService;
        this.updateGroupService = updateGroupService;
        this.deleteGroupService = deleteGroupService;
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group){
        return createGroupService.execute(group);
    }

    @GetMapping(path = "{groupId}")
    public Group getGroup(@PathVariable("groupId") Long groupId){
        return getGroupService.execute(groupId);
    }

    @DeleteMapping(path = "{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable("groupId") Long groupId){
        return deleteGroupService.execute(groupId);
    }

    @PutMapping(path = "{groupId}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long groupId,
                            @RequestBody Group group){
        return updateGroupService.execute(groupId, group);
    }




}
