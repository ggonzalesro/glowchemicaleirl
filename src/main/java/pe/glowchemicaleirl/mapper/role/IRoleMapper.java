package pe.glowchemicaleirl.mapper.role;

import org.mapstruct.Mapper;
import pe.glowchemicaleirl.dto.role.request.RoleRequestDTO;
import pe.glowchemicaleirl.dto.role.response.RoleResponseDTO;
import pe.glowchemicaleirl.repository.role.entity.RoleEntity;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    RoleResponseDTO toDTO(RoleEntity roleEntity);

    RoleEntity toEntity(RoleRequestDTO roleRequestDTO);
}
