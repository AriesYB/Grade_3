package com.bosssoft.learning.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Description jwt生成和解析token
 * @Date 2020/6/24 0:10
 * @Author HetFrame
 */
@Component
public class JwtUtil {
    /**
     * 签名用的密钥
     */
    private static final String SIGNING_KEY = "876gc3gyfhgj781brsez3372umyurji9";

    /**
     * @param exp
     * @param claims
     * @Description 创建token
     * @date 2020/6/23 22:17
     * @return: java.lang.String
     */
    public String createJwt(Date exp, Map<String, Object> claims) {
        //指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //保存在Payload（有效载荷）中的内容
                .setClaims(claims)
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //设置过期时间
                .setExpiration(exp)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, SIGNING_KEY);

        return builder.compact();
    }

    /**
     * @param token
     * @Description 解析token
     * @date 2020/6/23 22:18
     * @return: io.jsonwebtoken.Claims
     */
    public Claims parseJwt(String token) {
        //得到DefaultJwtParser
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token).getBody();
    }
}
