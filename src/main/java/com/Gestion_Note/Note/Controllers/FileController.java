package com.Gestion_Note.Note.Controllers;

import com.Gestion_Note.Note.Entities.File;
import com.Gestion_Note.Note.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/File")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/add")
    public ResponseEntity<String>addFile(@RequestBody File file){
        try{
            fileService.CreateFile(file);
            return ResponseEntity.ok("File added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error"+e.getMessage());
        }
    }
}
