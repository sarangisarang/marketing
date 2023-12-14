package com.example.demo.shop.security;
import com.example.demo.shop.domain.ServiceUser;
import com.example.demo.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final TransactionTemplate transactionTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return transactionTemplate.execute(status -> {
            ServiceUser serviceUser = userRepository.findUserByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("ServiceUser '" + username + "' not found"));
            List<SimpleGrantedAuthority> roles = serviceUser.getRoles().stream()
                    .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                    .toList();
            return new User(serviceUser.getUsername(),
                    serviceUser.getPassword(),
                    roles);
        });
    }
}
