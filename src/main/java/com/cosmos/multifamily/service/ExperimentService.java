package com.cosmos.multifamily.service;

import com.cosmos.multifamily.dto.ExperimentRequestDto;

/**
 * Created by YoungMan on 2018-12-19.
 */

public interface ExperimentService {

    void saveExperimentResult(ExperimentRequestDto experimentRequestDto);
}
