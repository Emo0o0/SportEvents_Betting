package com.example.sportevents_betting.rest.securityconfig;

import com.example.sportevents_betting.core.exceptions.bettinguser.BettingUserNotFoundException;
import com.example.sportevents_betting.persistence.entities.BettingUser;
import com.example.sportevents_betting.persistence.repositories.BettingUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BettingUserRepository bettingUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BettingUser user = bettingUserRepository.findByEmail(email).orElseThrow(() -> new BettingUserNotFoundException("Not found"));
        return new UserDetailsImpl(user);
    }
}
