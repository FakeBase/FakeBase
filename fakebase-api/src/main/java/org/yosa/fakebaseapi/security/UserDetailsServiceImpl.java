package org.yosa.fakebaseapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yosa.fakebasecore.domain.Account;
import org.yosa.fakebasecore.domain.Role;
import org.yosa.fakebasecore.repositories.AccountRepository;
import org.yosa.fakebasecore.services.AccountService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getByUsername(username);
        if(account == null)
            throw new UsernameNotFoundException(username);

        List<GrantedAuthority> user_roles = new ArrayList<GrantedAuthority>();
        for(Role i : account.getRoles())
            user_roles.add(new SimpleGrantedAuthority(i.name()));

        return new User(
                account.getUsername(),
                account.getPassword(),
                true,
                true,
                true,
                true,
                user_roles);
    }
}