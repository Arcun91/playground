package com.bob.plainOcr.service;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class OcrService {
    

    public String testOcr(){
        File image = new File("/home/bob/Scaricati/test2.jpg");
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("ita");
        tesseract.setDatapath("/usr/share/tessdata/");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        try {
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return "bad things..";
    }


}
