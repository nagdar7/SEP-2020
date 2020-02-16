package com.sep.NC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.sep.NC.model.Account;
import com.sep.NC.repository.AccountRepository;
import com.sep.NC.security.JWTUtils;
import com.sep.NC.service.AccountService;
import com.sep.NC.dto.AccountDTO;
import com.sep.NC.dto.LoginDTO;
import com.sep.NC.dto.TokenDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Qualifier("myUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${client.url}")
    private String clientUrl;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        try {
            log.info("login, dto user: {}", loginDTO.getUsername());
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                    loginDTO.getPassword());
            authenticationManager.authenticate(token);
            Account account = this.accountService.findByUsername(loginDTO.getUsername());

            UserDetails details = userDetailsService.loadUserByUsername(account.getUsername());

            TokenDTO userToken = new TokenDTO(jwtUtils.generateToken(details));

            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/registration", produces = "application/json")
    public @ResponseBody ResponseEntity<AccountDTO> registration(@RequestBody AccountDTO accountDTO,
            @PathVariable String taskId) throws Exception {
        log.info("postFormSubmission, dto username: {}", accountDTO.getUsername());
        accountDTO = accountService.createNewAccount(accountDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
