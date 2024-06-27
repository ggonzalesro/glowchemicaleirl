package pe.glowchemicaleirl.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.glowchemicaleirl.dto.user.request.UserRequestDTO;
import pe.glowchemicaleirl.dto.user.response.UserResponseDTO;
import pe.glowchemicaleirl.exception.RoleException;
import pe.glowchemicaleirl.service.user.IUserService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "/user",
        value = "/user"
)
public class UserController {

    private final IUserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) throws RoleException {
        return ResponseEntity.ok(userService.createUser(userRequestDTO));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDTO>> findUserByName(@RequestParam Optional<String> name) {
        return ResponseEntity.ok(userService.findUserByName(name));
    }
}
