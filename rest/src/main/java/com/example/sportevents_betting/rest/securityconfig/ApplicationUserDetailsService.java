//package com.example.sportevents_betting.rest.securityconfig;
//
//import com.example.sportevents_betting.core.exceptions.bookmaker.BookmakerNotFoundException;
//import com.example.sportevents_betting.persistence.entities.Bookmaker;
//import com.example.sportevents_betting.persistence.repositories.BookmakerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class ApplicationUserDetailsService implements UserDetailsService {
//
//    private final BookmakerRepository bookmakerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Bookmaker bookmaker = bookmakerRepository.findByEmail(username).orElseThrow(() -> new BookmakerNotFoundException("not found"));
//
//        return User.builder()
//                .username(bookmaker.getEmail())
//                .password(bookmaker.getPassword())
//                .authorities(Set.of(new SimpleGrantedAuthority("ROLE_USER")))
//                .build();
//    }
//}
