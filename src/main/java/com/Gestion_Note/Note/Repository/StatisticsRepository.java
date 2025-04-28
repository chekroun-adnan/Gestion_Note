package com.Gestion_Note.Note.Repository;

import com.Gestion_Note.Note.Entities.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics,Integer> {
    Statistics findById(int statisticsId);
}
