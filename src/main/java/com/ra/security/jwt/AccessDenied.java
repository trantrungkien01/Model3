package com.ra.security.jwt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessDenied implements AccessDeniedHandler {
    private Logger logger = LoggerFactory.getLogger(AccessDenied.class);
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logger.error("Un permission {}",accessDeniedException.getMessage());
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Un Authentication", HttpStatus.FORBIDDEN);
        response.setStatus(responseEntity.getStatusCode().value());
        response.getWriter().write("Un Authentication");
    }
}