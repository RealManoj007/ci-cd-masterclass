package com.infy.security.filter;

import com.infy.security.service.CustomUserDetailService;
import com.infy.security.utility.JwtUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    public static final Logger log=LoggerFactory.getLogger(JwtAuthFilter.class);

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private CustomUserDetailService customerDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //TODO: extract the token as request will land first here
        String authHeader = request.getHeader("Authorization");
        System.out.println("Auth Header: " + authHeader);
        String token=null;
        String username=null;
        if(authHeader!=null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtUtility.extractUsername(token);
            log.info(" token is {} & username is {}",token, username);
        }

        //TODO: validate token
        if(username!=null & SecurityContextHolder.getContext().getAuthentication()==null){
            //fetch user from DB using UserDetailsService and validate token
            UserDetails userDetails = customerDetailsService.loadUserByUsername(username);

            //TODO: add to securityContext
            if(jwtUtility.validateToken(username,userDetails,token)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }else{
            log.info("invalid token");
        }

        filterChain.doFilter(request,response);
    }
}
