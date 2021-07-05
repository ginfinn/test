package com.ginfin.test.jwt;


import com.ginfin.test.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin memberEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(memberEntity);
    }
}
