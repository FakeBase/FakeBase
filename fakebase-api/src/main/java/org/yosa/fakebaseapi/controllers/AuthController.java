package org.yosa.fakebaseapi.controllers;

import com.auth0.jwt.JWT;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yosa.fakebaseapi.exceptions.BadRequestException;
import org.yosa.fakebaseapi.payload.AccountRequest;
import org.yosa.fakebasecore.domain.Account;
import org.yosa.fakebasecore.domain.Role;
import org.yosa.fakebasecore.services.AccountService;

import java.util.*;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;
import static org.yosa.fakebaseapi.security.SecurityConstants.SECRET;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody AccountRequest account) {
        Account user = accountService.getByUsername(account.getUsername());

        List<String> user_roles = new ArrayList<String>();
        user.getRoles().forEach(e -> user_roles.add(e.name()));
        String roles = String.join(",", user_roles);

        String token = JWT.create()
                .withSubject(account.getUsername()).withClaim("Roles", roles)
                .sign(HMAC256(SECRET.getBytes()));
        user.setToken(token);

        return new HashMap<String, Object>(){{put("token", token);}};
    }

    @PostMapping("signup")
    public ResponseEntity<Account> signup(@RequestBody AccountRequest account){
        if(accountService.getByUsernameOptional(account.getUsername()).isPresent())
            throw new BadRequestException("Username is already in use");
        return new ResponseEntity<>(accountService.create(
                new Account(account.getUsername(),
                        account.getEmail(),
                        account.getPassword(),
                        new Date(),
                        Collections.singleton(Role.ROLE_USER))), HttpStatus.CREATED);
    }
}
