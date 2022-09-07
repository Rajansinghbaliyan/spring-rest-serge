package io.cherrytechnologies.springrestserge.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cherrytechnologies.springrestserge.SpringApplicationContext;
import io.cherrytechnologies.springrestserge.security.jwt.JwtUtils;
import io.cherrytechnologies.springrestserge.service.UserService;
import io.cherrytechnologies.springrestserge.shared.dto.UserDto;
import io.cherrytechnologies.springrestserge.ui.model.request.UserLoginRequestModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private String contentType;

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        try {
            contentType = request.getHeader("Accept");
            UserLoginRequestModel model = new ObjectMapper()
                    .readValue(request.getInputStream(), UserLoginRequestModel.class);


            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    model.getEmail(),
                    model.getPassword()
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String token = JwtUtils.tokenBuilder(user.getUsername());

        UserService userService = (UserService) SpringApplicationContext.getBeans("userServiceImpl");

        UserDto dto = userService.findByEmail(user.getUsername());

        response.addHeader("UserId",dto.getUserId().toString());
        response.addHeader(SecurityConstants.getAuthenticationHeader(), SecurityConstants.getJwtPrefix() + token);
    }
}
