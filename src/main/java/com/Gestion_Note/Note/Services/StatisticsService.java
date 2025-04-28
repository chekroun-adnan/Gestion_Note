package com.Gestion_Note.Note.Services;

import com.Gestion_Note.Note.Entities.Statistics;
import com.Gestion_Note.Note.Repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepo;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepo) {
        this.statisticsRepo = statisticsRepo;
    }

    public void CreateStats(Statistics stats) throws Exception{
        Statistics ExistingStatistics = statisticsRepo.findById(stats.getStatisticsId());
        if(ExistingStatistics != null){
            statisticsRepo.save(stats);
        }else{
            throw new Exception("Statistics already exists with ID: "+ stats.getStatisticsId());
        }
    }
    public Statistics getStatistics(int statisticsId) throws Exception {
        Statistics ExistingStatistics = statisticsRepo.findById(statisticsId);
        if(ExistingStatistics != null){
            return ExistingStatistics;
        }else{
            throw new Exception("Statistics not found with Id:"+ statisticsId);
        }

    }

    public void updateStatistics(Statistics stats) throws Exception{
        Statistics ExistingStatistics = statisticsRepo.findById(stats.getStatisticsId());
        if(ExistingStatistics != null){
            ExistingStatistics.setGeneralAverage(stats.getGeneralAverage());
            ExistingStatistics.setAssignmentAverage(stats.getAssignmentAverage());
            ExistingStatistics.setSubjectAverage(stats.getSubjectAverage());
            statisticsRepo.save(ExistingStatistics);
        }else{
            throw new Exception("Statistics not found with Id:"+ stats.getStatisticsId());
        }
    }

    public void deleteStatistics(int statisticsId) throws Exception{
        Statistics ExistingStatistics = statisticsRepo.findById(statisticsId);
        if(ExistingStatistics != null){
            statisticsRepo.delete(ExistingStatistics);
        }else{
            throw new Exception("Statistics not found with Id"+ statisticsId);
        }
    }
}
