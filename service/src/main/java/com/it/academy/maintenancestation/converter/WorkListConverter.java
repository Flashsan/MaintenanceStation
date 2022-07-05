package com.it.academy.maintenancestation.converter;

import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import org.springframework.stereotype.Component;

@Component
public class WorkListConverter
        extends AbstractConverter<WorkList, WorkListDto> {
    public WorkListConverter() {
        super(WorkList.class, WorkListDto.class);
    }
}
