package pe.glowchemicaleirl.service.user;

import pe.glowchemicaleirl.dto.user.request.UserRequestDTO;
import pe.glowchemicaleirl.dto.user.response.UserResponseDTO;
import pe.glowchemicaleirl.exception.RoleException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws RoleException;
    List<UserResponseDTO> findUserByName(Optional<String> name);
}
