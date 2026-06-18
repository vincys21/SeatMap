package it.benefind.seatmap.mapper;

import org.mapstruct.Mapper;

import it.benefind.seatmap.dto.AddEditUserDTO;
import it.benefind.seatmap.dto.UpdateUserDTO;
import it.benefind.seatmap.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	AddEditUserDTO toDTO(User user);
	User toEntity(AddEditUserDTO user);
	
	UpdateUserDTO toUpdateDTO(User user);
	User toEntity(UpdateUserDTO user);
}
