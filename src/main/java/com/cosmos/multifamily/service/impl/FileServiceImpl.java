package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Service
public class FileServiceImpl implements FileService {
    private final String WINDOW_PATH = "C:\\test\\";
    private final String LINUX_PATH = "/home/ec2-user/wavefiles/";

    @Override
    public ResponseEntity<InputStreamResource> downloadFileByLevel(String level) throws Exception {
        String filePath = WINDOW_PATH + level + "\\";
        File file = getRandFile(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length())
                .body(resource);
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadFileByName(String fileName) throws Exception {
        String filePath = LINUX_PATH + fileName;
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.length())
                .body(resource);
    }

    private File getRandFile(String filePath) {
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        Random rand = new Random();
        File randFile = fileList[rand.nextInt(fileList.length)];

        return randFile;
    }
}
