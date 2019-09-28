package com.signon.utils;

import com.signon.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckValidity  {


    private boolean isExpire;

    private boolean getExpire() {
        return isExpire;
    }

    private boolean setIsexpire(boolean isexpire) {
        this.isExpire = isexpire;
        return isexpire;
    }

    @Value("${jwt.secret}")
    private String secret;

    public String check(String token) {


        Claims claims = extract(token);
        Date expirationDate = claims.getExpiration();
        String email=claims.getSubject();
        if (expirationDate.after(new Date(System.currentTimeMillis()))) {

            return "Token Checked";

            //return email;
        } else {
            throw new InvalidTokenException("token is expired");
        }
    }

    private Claims extract(String token) {
       return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


}