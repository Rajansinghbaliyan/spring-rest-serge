package io.cherrytechnologies.springrestserge.security.jwt;

import io.cherrytechnologies.springrestserge.security.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    public static String tokenBuilder(String email){
        return Jwts.builder()
                .setSubject(email)
                .setExpiration( new Date(System.currentTimeMillis() + SecurityConstants.getTokenExpiration()))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512 , SecurityConstants.getTokenSecret())
                .compact();
    }
}
