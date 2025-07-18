package com.example.fullStackTest.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final Logger log = LoggerFactory.getLogger(JWTUtil.class);

    /**
     * Create a new token.
     *
     * @param id
     * @param subject
     * @return JWT String
     */
    public String create(String id, String subject) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);


        SecretKey signingKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signingKey, signatureAlgorithm);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    /**
     * Method to validate and read the JWT - obtiene el subject
     *
     * @param jwt Token JWT
     * @return Subject del JWT
     */
    public String getValue(String jwt) {
        try {
            SecretKey signingKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            return claims.getSubject();
        } catch (JwtException e) {
            log.error("JWT inválido o expirado", e);
            return null;
        }
    }

    /**
     * Method to validate and read the JWT - obtiene el id
     *
     * @param jwt Token JWT
     * @return Id del JWT
     */
    public String getKey(String jwt) {
        try {
            SecretKey signingKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            return claims.getId();
        } catch (JwtException e) {
            log.error("JWT inválido o expirado", e);
            return null;
        }
    }
}
