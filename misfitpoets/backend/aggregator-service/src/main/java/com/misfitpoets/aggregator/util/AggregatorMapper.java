package com.misfitpoets.aggregator.util;

import com.misfitpoets.aggregator.domain.AggregatedRecord;
import com.misfitpoets.aggregator.dto.AggregatorResponse;
import org.springframework.stereotype.Component;

@Component
public class AggregatorMapper {

    public AggregatorResponse toResponse(AggregatedRecord record) {
        AggregatorResponse resp = new AggregatorResponse();
        resp.setRecordId(record.getId());
        resp.setSourceName(record.getSourceName());
        resp.setProcessedData(record.getProcessedData());
        return resp;
    }
}
