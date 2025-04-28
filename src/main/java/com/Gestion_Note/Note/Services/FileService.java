package com.Gestion_Note.Note.Services;

import com.Gestion_Note.Note.Entities.File;
import com.Gestion_Note.Note.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileRepository filerepo;

    @Autowired
    public FileService(FileRepository filerepo) {
        this.filerepo = filerepo;
    }

    public void CreateFile(File file) throws Exception{
        File fileExist = filerepo.findById(file.getFileId());
        if(fileExist == null){
            filerepo.save(file);
        }else{
            throw new Exception("File already exists with ID:" + file.getFileId());
        }
    }

    public File getFile(int fileid) throws Exception{
        File fileExist = filerepo.findById(fileid);
        if(fileExist == null){
            return fileExist;
        }else {
            throw new Exception("File not found with Id:"+fileid);
        }
    }

    public void updateFile(File file) throws Exception{
        File fileExist = filerepo.findById(file.getFileId());
        if (fileExist != null){
            fileExist.setName(file.getName());
            fileExist.setSize(file.getSize());
            fileExist.setSize(file.getSize());
            fileExist.setType(file.getType());
            fileExist.setUrl(file.getUrl());
            filerepo.save(fileExist);
        }else{
            throw new Exception("File not found with Id"+ file.getFileId());
        }
    }

    public void deleteFile(int fileId)throws Exception{
        File fileExist = filerepo.findById(fileId);
        if (fileExist != null){
            filerepo.delete(fileExist);
        }else {
            throw new Exception("File not found with Id:"+fileId);
        }
    }
}
