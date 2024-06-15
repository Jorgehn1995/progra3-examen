package com.progra.examen.services;


import com.progra.examen.repositories.UserRepository;
import com.progra.examen.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionalUser = this.userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            return new SecurityUser(optionalUser.get());
        }
        throw new UsernameNotFoundException("User not found " + username);
    }
}