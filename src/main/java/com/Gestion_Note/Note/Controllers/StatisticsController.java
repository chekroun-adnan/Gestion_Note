package com.Gestion_Note.Note.Controllers;

import com.Gestion_Note.Note.Entities.Statistics;
import com.Gestion_Note.Note.Entities.User;
import com.Gestion_Note.Note.Services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsservice) {
        this.statisticsService = statisticsservice;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStatistic(@RequestBody Statistics stats) {
        try {
            statisticsService.CreateStats(stats);
            return ResponseEntity.ok("Statistic added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public Statistics getStats(@RequestParam int statisticsId){
        try{
            return statisticsService.getStatistics(statisticsId);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    @PutMapping("/update")
    public  ResponseEntity<String> updateStatistic(@RequestBody Statistics stats) {
        try{
            statisticsService.updateStatistics(stats);
            return ResponseEntity.ok("Statistic updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    public ResponseEntity<String> deleteStatistic(@RequestParam int id){
        try{
            statisticsService.deleteStatistics(id);
            return ResponseEntity.ok("Statistic deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    }
