package com.khaidev.springboot.controllers;

import com.khaidev.springboot.models.ResponseObject;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/api/v1/FileUpload")
public class FileUploadController {
//    @PostMapping("")
//    public EntityManager<ResponseObject> uploadFile(@RequestParam("file")MultipartFile file){
//        try {
//
//        }catch (Exception e){
//
//        }
//    }
}
