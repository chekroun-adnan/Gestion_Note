package com.Gestion_Note.Note.Controllers;

import com.Gestion_Note.Note.Entities.Assignment;
import com.Gestion_Note.Note.Services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAssignment(@RequestBody Assignment assignment){
        try {
            assignmentService.CreateAssignment(assignment);
            return ResponseEntity.ok("Assignment added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error"+ e.getMessage());
        }
    }

    @GetMapping("/get")
    public Assignment getAssignment (@RequestParam int assignmentId){
        try {
            return assignmentService.getAssignment(assignmentId);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateAssignment(@RequestBody Assignment assignment){
        try{
            assignmentService.UpdateAssignment(assignment);
            return ResponseEntity.ok("Assignment updated successfully");
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAssignment(@RequestParam int id){
        try{
            assignmentService.deleteAssignment(id);
            return ResponseEntity.ok("Assignment deleted successfully");
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    }
