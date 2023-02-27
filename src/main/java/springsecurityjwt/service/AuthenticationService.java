package springsecurityjwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import springsecurityjwt.dto.UserDto;
import springsecurityjwt.dto.UserRequest;
import springsecurityjwt.dto.UserResponse;
import springsecurityjwt.entity.User;
import springsecurityjwt.enums.Role;
import springsecurityjwt.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public UserResponse save(UserDto userDto) {
        User user = User.builder().username(userDto.getUsername())
                .password(userDto.getPassword()).nameSurname(userDto.getUsername())
                .role(Role.USER).build();
        userRepository.save(user);

        var token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }

    public UserResponse auth(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
}
