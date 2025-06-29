package com.stringtinyst.healthlife.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static String signKey = "stringtiny";
    private static Long expire = 43200000L;

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        if (jwt == null || jwt.isEmpty()) {
            throw new IllegalArgumentException("token 不能为空");
        }

        try {
            return Jwts.parser()
                    .setSigningKey(signKey)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            throw new IllegalArgumentException("无效的 token", e);
        }
    }

}
