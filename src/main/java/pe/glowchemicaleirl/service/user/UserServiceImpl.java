package pe.glowchemicaleirl.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.glowchemicaleirl.dto.role.request.RoleRequestDTO;
import pe.glowchemicaleirl.dto.user.request.UserRequestDTO;
import pe.glowchemicaleirl.dto.user.response.UserResponseDTO;
import pe.glowchemicaleirl.exception.RoleException;
import pe.glowchemicaleirl.mapper.user.IUserMapper;
import pe.glowchemicaleirl.repository.role.dao.IRoleRepository;
import pe.glowchemicaleirl.repository.role.entity.RoleEntity;
import pe.glowchemicaleirl.repository.user.dao.IUserRepository;
import pe.glowchemicaleirl.repository.user.entity.UserEntity;
import pe.glowchemicaleirl.util.EnumRole;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService{

    final IUserRepository userRepository;
    final IRoleRepository roleRepository;
    final IUserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws RoleException {

        Set<RoleEntity> roleEntities = new HashSet<>();

        for (RoleRequestDTO roleDTO : userRequestDTO.getRoles()){
            Optional<RoleEntity> existingRole = roleRepository.findByName(EnumRole.fromString(roleDTO.getName()));

            existingRole.ifPresent(roleEntities::add);
        }

        UserEntity userEntity = userMapper.toEntity(userRequestDTO);
        userEntity.setRoles(roleEntities);

        UserEntity userEntitySaved = userRepository.save(userEntity);
        return userMapper.toDTO(userEntitySaved);
    }

    @Override
    public List<UserResponseDTO> findUserByName(Optional<String> name) {
        List<UserEntity> userEntities;
        if(name.isEmpty()){
             userEntities = userRepository.findByNameLike("%");
        }else {
             userEntities = userRepository.findByNameLike("%".concat(name.get()).concat("%"));
        }
        return userMapper.toDTOS(userEntities);
    }
}
