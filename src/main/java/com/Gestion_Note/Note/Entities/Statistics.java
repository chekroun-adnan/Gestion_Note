package com.Gestion_Note.Note.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statisticsId;
    private double generalAverage;
    private double assignmentAverage;
    private double subjectAverage;

    public Statistics(){

    }

    public Statistics(int statisticsId, double generalAverage, double assignmantAverage, double subjectAverage) {
        this.statisticsId = statisticsId;
        this.generalAverage = generalAverage;
        this.assignmentAverage = assignmantAverage;
        this.subjectAverage = subjectAverage;
    }

    public int getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(int statisticsId) {
        this.statisticsId = statisticsId;
    }

    public double getGeneralAverage() {
        return generalAverage;
    }

    public void setGeneralAverage(double generalAverage) {
        this.generalAverage = generalAverage;
    }

    public double getAssignmentAverage() {
        return assignmentAverage;
    }

    public void setAssignmentAverage(double assignmentAverage) {
        this.assignmentAverage = assignmentAverage;
    }

    public double getSubjectAverage() {
        return subjectAverage;
    }

    public void setSubjectAverage(double subjectAverage) {
        this.subjectAverage = subjectAverage;
    }
}
