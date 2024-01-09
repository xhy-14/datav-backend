package io.renren.modules.app.service.data;

import io.renren.modules.app.dto.GeneratedParameterDTO;

import java.util.List;

public interface GeneratedParameterService {

    Boolean saveGeneratedParameters(List<GeneratedParameterDTO> parameters, Long GeneratedChartId);

}
