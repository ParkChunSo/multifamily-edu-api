package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2018-12-19.
 */

@RestController
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("downloads/level/{level}")
    public ResponseEntity<InputStreamResource> downloadFileByLevel(@PathVariable("level") String level) throws Exception {
        return fileService.downloadFileByLevel(level);
    }

    @GetMapping("downloads/level/{level}/filename/{filename}")
    public ResponseEntity<InputStreamResource> downloadFileByFileName(@PathVariable("level") String level,
                                                                      @PathVariable("filename") String fileName) throws Exception {
        return fileService.downloadFileByName(fileName);
    }

}
