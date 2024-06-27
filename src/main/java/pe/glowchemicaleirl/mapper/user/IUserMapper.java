package pe.glowchemicaleirl.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import pe.glowchemicaleirl.dto.user.request.UserRequestDTO;
import pe.glowchemicaleirl.dto.user.response.UserResponseDTO;
import pe.glowchemicaleirl.repository.user.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {

    UserResponseDTO toDTO(UserEntity userEntity);

    UserEntity toEntity(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> toDTOS(List<UserEntity> userEntities);

    List<UserEntity> toEntities(List<UserRequestDTO> userRequestDTOS);

}
