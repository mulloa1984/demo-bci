package com.mulloa.demobci.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mulloa.demobci.Bean.ResponseUser;
import com.mulloa.demobci.Bean.ResponseErrorMsg;
import com.mulloa.demobci.Bean.ResponseUserService;
import com.mulloa.demobci.Bean.LoginRequest;
import com.mulloa.demobci.Bean.RequestUser;
import com.mulloa.demobci.Jwt.JwtService;
import com.mulloa.demobci.Model.Role;
import com.mulloa.demobci.Model.User;
import com.mulloa.demobci.Model.Phone;
import com.mulloa.demobci.Repositories.PhoneRepository;
import com.mulloa.demobci.Repositories.UserRepository;
import com.mulloa.demobci.helper.Constantes;

import java.util.regex.*;
import lombok.RequiredArgsConstructor;

/**
 * @author MILLER
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {
	private static Logger LOG = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	private final PhoneRepository phoneRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
	
    public ResponseUser login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(user);
       
        return ResponseUser.builder()
            .token(token)
            .build();
    }
	    
    public ResponseUserService register(RequestUser requestUser){
    	ResponseUserService salida = new ResponseUserService();
    	ResponseUser responseUser = new ResponseUser();
    	ResponseErrorMsg errorMsg = new ResponseErrorMsg();
    	LocalDateTime now = LocalDateTime.now();

        LOG.info("requestUser.getPassword()" + requestUser.getPassword());
		
        try {
        	User user = User.builder()
                	.createdAt(now)
                	.updatedAt(now)
                    .name(requestUser.getName())
                    .username(requestUser.getEmail())
                    .password(passwordEncoder.encode( requestUser.getPassword()))
                    .isActive(true)
                    .role(Role.USER)
                    .build();

        	LOG.info("Validando user : " + user);
        	LOG.info("Validando getPhones() : " + requestUser.getPhones());
                
        	if(!validaEmail(requestUser.getEmail())) {
        		salida.setCodeError(1);
        		errorMsg.setMensaje("Formato de correo Incorrecto.");
        		
        		LOG.warn("Formato de correo Incorrecto:  " + requestUser.getEmail());        		
        	}else if(existeUser(requestUser)) {
        		salida.setCodeError(2);
        		errorMsg.setMensaje("El correo ya registrado.");

        		LOG.warn("El correo ya registrado:  " + requestUser.getEmail());
        	}else {
        		userRepository.save(user);
            	for(Phone phone : requestUser.getPhones())
            	{
            		phone.setUser(user);
            		phoneRepository.save(phone);
            	}

        		responseUser.setId(user.getId().toString());
        		responseUser.setCreatedAt(user.getCreatedAt().toString());
        		responseUser.setUpdatedAt(user.getUpdatedAt().toString());
        		responseUser.setToken(jwtService.getToken(user));
        		responseUser.setIsActive((user.isActive())?"true":"false");
                
        		salida.setCodeError(0);
        		salida.setResponseUser(responseUser);
        	}
        }catch (Exception e) {
        	LOG.error("Ha ocurrido un error al Registrar Usuario, ERROR > " + e);

        	salida.setCodeError(-1);
        	errorMsg.setMensaje("Ha ocurrido un error al Registrar Usuario");
		}
        
        salida.setMensajeError(errorMsg);
        return salida;
    }
    
    public boolean validaEmail(String email) {
        // Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(Constantes.FORMAT_REGULAR_EXPRESION);
        Matcher matcher = pattern.matcher(email);
    	
    	return matcher.matches();
    }
    
    public boolean existeUser(RequestUser requestUser) {
    	Optional<User> resp = userRepository.findByUsername(requestUser.getEmail());

    	return !resp.isEmpty();
    }
}
