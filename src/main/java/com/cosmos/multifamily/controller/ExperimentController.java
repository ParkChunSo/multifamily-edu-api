package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.dto.ExperimentRequestDto;
import com.cosmos.multifamily.service.ExperimentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2018-12-19.
 */

@RestController
public class ExperimentController {

    private final ExperimentService experimentService;

    public ExperimentController(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @RequestMapping(value = "experiments", method = RequestMethod.POST)
    public void saveExperimentResult(@RequestBody ExperimentRequestDto experimentRequestDto) {
        experimentService.saveExperimentResult(experimentRequestDto);
    }
}
