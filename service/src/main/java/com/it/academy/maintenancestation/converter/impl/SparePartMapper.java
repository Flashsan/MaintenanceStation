package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class SparePartMapper
        extends AbstractMapper<SparePart, SparePartDto> {

    private final ModelMapper mapper;
    private final WorkListRepository workListRepository;

    @Autowired
    public SparePartMapper(ModelMapper mapper, WorkListRepository workListRepository) {
        super(SparePart.class, SparePartDto.class);
        this.mapper = mapper;
        this.workListRepository = workListRepository;
    }

//    @PostConstruct
//    public void setupMapper() {
//        mapper.createTypeMap(SparePart.class, SparePartDto.class)
//                .addMappings(m -> m.skip(SparePartDto::setWorkListId)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(SparePartDto.class, SparePart.class)
//                .addMappings(m -> m.skip(SparePart::setWorkList)).setPostConverter(toEntityConverter());
//    }
//
//    @Override
//    void mapSpecificFieldsEntityToDto(SparePart source, SparePartDto destination) {
//        destination.setWorkListId(getId(source));
//    }
//
//    private Integer getId(SparePart source) {
//        return Objects.isNull(source) || Objects.isNull(source.getWorkList()) ? null : source.getSparePartId();
//    }
//
//    @Override
//    void mapSpecificFieldsDtoToEntity(SparePartDto source, SparePart destination) {
//        destination.setWorkList(workListRepository.findById(source.getWorkListId()).orElse(null));
//    }


}
