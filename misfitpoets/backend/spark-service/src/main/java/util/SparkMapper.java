package com.misfitpoets.spark.util;

import com.misfitpoets.spark.domain.SparkPrompt;
import com.misfitpoets.spark.dto.SparkResponse;
import org.springframework.stereotype.Component;

@Component
public class SparkMapper {

    public SparkResponse toResponse(SparkPrompt entity) {
        SparkResponse resp = new SparkResponse();
        resp.setId(entity.getId());
        resp.setTheme(entity.getTheme());
        resp.setStyle(entity.getStyle());
        resp.setTone(entity.getTone() != null ? entity.getTone().name() : null);
        resp.setPromptText(entity.getPromptText());
        resp.setOwnerId(entity.getOwnerId());
        return resp;
    }
}
