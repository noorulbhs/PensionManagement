package com.fse0.microservice.loginservice.controller;

import com.fse0.microservice.loginservice.helper.JWTUtil;
import com.fse0.microservice.loginservice.model.JWTRequest;
import com.fse0.microservice.loginservice.model.JWTResponse;
import com.fse0.microservice.loginservice.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity generateToken(@RequestBody JWTRequest jwtRequest) throws Exception {

        try{
            this.authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    jwtRequest.getUsername(),
                                    jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        String username=this.jwtUtil.extractUsername(token);

        return ResponseEntity.ok(new JWTResponse(token,username));
    }

    @GetMapping("/validate")
    public ResponseEntity getValidity(@RequestHeader("Authorization") String token) throws Exception {
        ResponseEntity responseEntity=null;
        System.out.println("Token     "+token);
        if(token.startsWith("Bearer ")){
            token=token.substring(7);
            if(jwtUtil.validateToken(token)){
                String username=jwtUtil.extractUsername(token);
                return responseEntity=new ResponseEntity(username,HttpStatus.OK);
            }else{
                return  responseEntity=new ResponseEntity("Token expired", HttpStatus.FORBIDDEN);
            }
        }else{
            return responseEntity=new ResponseEntity("Invalid Token",HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";
    }

}
