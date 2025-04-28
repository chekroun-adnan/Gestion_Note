package com.Gestion_Note.Note.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int assignmentId;
    private String Title;
    private String description;
    private Date deadline;

    public Assignment(){

    }

    public Assignment(int assignmentId, String description, String title, Date deadline) {
        this.assignmentId = assignmentId;
        this.description = description;
        this.Title = title;
        this.deadline = deadline;
    }

    public  int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
