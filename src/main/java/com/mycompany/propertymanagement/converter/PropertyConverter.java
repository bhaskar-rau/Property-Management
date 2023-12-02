package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PropertyConverter {
    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());

        pe.setPrice(propertyDTO.getPrice());
        return pe;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO= new PropertyDTO();
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setAddress(propertyEntity.getAddress());

        propertyDTO.setPrice(propertyEntity.getPrice());
        return propertyDTO;
    }
}
