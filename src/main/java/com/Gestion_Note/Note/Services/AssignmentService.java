package com.Gestion_Note.Note.Services;

import com.Gestion_Note.Note.Entities.Assignment;
import com.Gestion_Note.Note.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepo;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    public void CreateAssignment(Assignment assignment) throws Exception {
        Assignment existingAssignment = assignmentRepo.findById(assignment.getAssignmentId());
        if (existingAssignment != null) {
            assignmentRepo.save(assignment);
        } else {
            throw new Exception("Assignment already exists with ID: " + assignment.getAssignmentId());
        }
    }

    public Assignment getAssignment(int assignmentId) throws Exception {
        Assignment ExistingAssignment = assignmentRepo.findById(assignmentId);
        if (ExistingAssignment != null) {
            return ExistingAssignment;
        } else {
            throw new Exception("Assignment not found with Id" + assignmentId);

        }

    }

    public void UpdateAssignment(Assignment assignment) throws Exception {
        Assignment ExistingAssignment = assignmentRepo.findById(assignment.getAssignmentId());
        if (ExistingAssignment != null) {
            ExistingAssignment.setTitle(assignment.getTitle());
            ExistingAssignment.setDescription(assignment.getDescription());
            ExistingAssignment.setDeadline(assignment.getDeadline());
            assignmentRepo.save(ExistingAssignment);
        }else{
            throw new Exception("Assignment not found with Id:"+ assignment.getAssignmentId());
        }
    }

    public void deleteAssignment(int assignmentId) throws Exception {
        Assignment ExistingAssignment = assignmentRepo.findById(assignmentId);
        if (ExistingAssignment != null) {
            assignmentRepo.delete(ExistingAssignment);
        } else {
            throw new Exception("Assignment not found with Id" + assignmentId);
        }

    }


}
