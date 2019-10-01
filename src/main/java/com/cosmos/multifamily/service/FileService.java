package com.cosmos.multifamily.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

/**
 * Created by YoungMan on 2018-12-19.
 */

public interface FileService {

    ResponseEntity<InputStreamResource> downloadFileByLevel(String level) throws Exception;

    ResponseEntity<InputStreamResource> downloadFileByName(String fileName) throws Exception;
}
