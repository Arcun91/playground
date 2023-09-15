package com.bob.plainOcr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bob.plainOcr.service.OcrService;

@RestController
public class OcrController {
    
    @Autowired
    private OcrService ocrService;

    @GetMapping
    public String testOcrRecognition(){
        System.out.print("ping");
        return ocrService.testOcr();
    }

}
