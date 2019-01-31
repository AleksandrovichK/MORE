package com.ibagroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.config.JwtTokenUtil;
import com.ibagroup.dto.AuthToken;
import com.ibagroup.dto.LoginForm;
import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;
import com.ibagroup.services.impl.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    private IUserService userService;
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sign-in")
    public ResponseEntity signIn(@RequestBody LoginForm loginForm) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        User user = userService.findOne(loginForm.getUsername());
        String token = jwtTokenUtil.generateToken(user);
        return new ResponseEntity<>(new RestResponse(new AuthToken(token, user.getUsername())), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sign-up")
    public ResponseEntity signUp(@RequestBody User user) {
        User result = userService.create(user);

        if (result != null) {
            return new ResponseEntity<>(new RestResponse(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new RestResponse(), HttpStatus.BAD_REQUEST);
        }
    }


}
