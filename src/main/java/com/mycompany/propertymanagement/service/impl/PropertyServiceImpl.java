package com.mycompany.propertymanagement.service.impl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();

        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe: listOfProps){
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
            propList.add(dto);
        }
        return propList;

    }
    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId){
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());

            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId){
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId){
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }

        return dto;
    }

    @Override
    public void  deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
