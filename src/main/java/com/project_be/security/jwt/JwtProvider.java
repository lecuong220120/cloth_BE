package com.project_be.security.jwt;

import com.project_be.security.userprincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private String jwtSecret = "levancuong";
    private int jwtExpired = 864000000;
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);
    public String createToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpired * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            LOGGER.error("Invalid JWT signature: {}", e.getMessage());
        }catch (MalformedJwtException e){
            LOGGER.error("Invalid format token: {}", e.getMessage());
        }catch (ExpiredJwtException e){
            LOGGER.error("Expired JWT token: {}", e.getMessage());
        }catch (UnsupportedJwtException e){
            LOGGER.error("Unsupported JWT token: {}", e.getMessage());
        }catch (IllegalArgumentException e){
            LOGGER.error("JWT claims string empty: {}", e.getMessage());
        }
        return false;
    }
    public String getUserNameFromToken(String token){
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return username;
    }
}
