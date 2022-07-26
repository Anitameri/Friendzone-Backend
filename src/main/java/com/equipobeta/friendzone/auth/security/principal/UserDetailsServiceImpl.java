package com.equipobeta.friendzone.auth.security.principal;

import com.equipobeta.friendzone.auth.security.user.User;
import com.equipobeta.friendzone.auth.security.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> all = getAllUsers();
        for(User u : all)
            if(u.getUsername().equals(username))
                return u;
        throw new UsernameNotFoundException("User Not Found: " + username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){

        return userRepository.findById(id);

    }

    public User create(User user){
        return userRepository.save(user);
    }
}