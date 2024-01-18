package com.ra.security.jwt;

import com.ra.security.user_principal.UserPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.hibernate.annotations.Comment;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ExecutionException;
@Component
public class JwtProvider {
    @Value("${expired}")
    private Long EXPIRED;
    @Value("${secret_key}")
    private String SECRET_KEY;
    private Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    public String generateToken(UserPrincipal userPrincipal) {
        String token = Jwts.builder().setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + EXPIRED)).
                signWith(SignatureAlgorithm.ES512, SECRET_KEY).compact();
        return token;
    }

    public Boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(token);
            return true;
        } catch (ExpiredJwtException expiredJwtException) {
            logger.error("Expried Token{}", expiredJwtException.getMessage());
        } catch (SignatureException signatureException) {
            logger.error("Invalid Signature Token {}", signatureException.getMessage());
        }
        return false;
    }
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(token).getBody().getSubject();
    }
}
