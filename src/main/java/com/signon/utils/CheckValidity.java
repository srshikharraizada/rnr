package com.signon.utils;

import com.signon.exception.InvalidTokenException;
import com.signon.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckValidity  {


    private boolean isexpire;

    private boolean getIsexpire() {
        return isexpire;
    }

    private boolean setIsexpire(boolean isexpire) {
        this.isexpire = isexpire;
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
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }


}