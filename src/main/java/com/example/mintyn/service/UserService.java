package com.example.mintyn.service;

import com.example.mintyn.dto.SignUpRequest;
import com.example.mintyn.model.Token;
import com.example.mintyn.model.User;
import com.example.mintyn.repository.UserRepository;
import com.example.mintyn.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public ResponseEntity<String> signUp(SignUpRequest signUpRequest) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        // Create a new user entity and set properties
        User newUser = new User();
        newUser.setUsername(signUpRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword())); // Hash the password

        // Save the user to the database
        userRepository.save(newUser);

        // Return a successful response
        return ResponseEntity.ok("User signed up successfully");
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public Token getToken(String username){
        String tokenValue = jwtService.createToken(username);
        return new Token(tokenValue);
    }

}

