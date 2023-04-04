package br.com.robson.java_lambda;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JwtReader {

    private final SecretKey key;

    public JwtReader() {
        String secret = System.getenv("JWT_SECRET");
        byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);
        this.key = new SecretKeySpec(secretBytes, "HS256");
    }

    public String readJwt(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(key)
                .setSigningKey(key)
                .parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims.getSubject();
    }

}