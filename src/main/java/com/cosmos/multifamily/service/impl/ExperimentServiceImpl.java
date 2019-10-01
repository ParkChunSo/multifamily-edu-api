package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.dto.ExperimentRequestDto;
import com.cosmos.multifamily.domain.Experiment;
import com.cosmos.multifamily.repository.ExperimentRepository;
import com.cosmos.multifamily.service.ExperimentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Service
public class ExperimentServiceImpl implements ExperimentService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    private final ExperimentRepository experimentRepository;

    public ExperimentServiceImpl(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    public void saveExperimentResult(ExperimentRequestDto experimentRequestDto) {
        Experiment experiment = experimentRequestDto.toEntity();
        experimentRepository.save(experiment);
    }
}
