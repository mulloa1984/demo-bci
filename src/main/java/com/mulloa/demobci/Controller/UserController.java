package com.mulloa.demobci.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mulloa.demobci.Bean.RequestUser;
import com.mulloa.demobci.Bean.ResponseUserService;
import com.mulloa.demobci.Service.UserService;
import com.mulloa.demobci.helper.Constantes;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Constantes.APP_NAME+Constantes.APP_VERSION)
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
    /*
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(userService.login(request));
    }*/

    @PostMapping(value = "register")
    public ResponseEntity<?> register(@RequestBody RequestUser request)
    {
    	ResponseUserService responseUserService = userService.register(request);
    	
    	if(responseUserService.getCodeError() == -1) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseUserService.getMensajeError());
    	}else if(responseUserService.getCodeError() == 1) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseUserService.getMensajeError());
    	}else if(responseUserService.getCodeError() == 2) {
    		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(responseUserService.getMensajeError());
    	}else {
    		return ResponseEntity.status(HttpStatus.CREATED).body(responseUserService.getResponseUser());
    	}	
    }
}



