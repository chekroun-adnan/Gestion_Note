package com.Gestion_Note.Note.Repository;

import com.Gestion_Note.Note.Entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<File,Integer> {

    File findById(int fileId);
}
