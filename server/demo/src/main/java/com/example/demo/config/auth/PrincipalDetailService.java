package com.example.demo.config.auth;

import com.example.demo.artist.repository.ArtistRepository;
import com.example.demo.fans.entity.Fans;
import com.example.demo.fans.repository.FansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final FansRepository fansRepository;
    private final ArtistRepository artistRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Fans> fansEntity  = fansRepository.findByEmail(email);
        //if(userEntity==null){
        //    Optional<Artist> artistEntity  = artistRepository.findByEmail(email);
        //    return new PrincipalDetails(artistEntity.get());
        //}
        return new PrincipalDetails(fansEntity.get());
    }
}
