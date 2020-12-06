package com.silklee.common.utils;

import com.silklee.common.exception.BizException;
import com.silklee.common.exception.BizExceptionCommonEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtils {


    /**
     * 由字符串生成加密key
     *
     * @return
     */
    private static Key getKeyInstance(String secret) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary(secret);
        return new SecretKeySpec(bytes, signatureAlgorithm.getJcaName());
    }

    /**
     * token
     *
     * @param map           载荷中的数据
     * @param expireMinutes 过期时间，单位秒
     * @return
     * @throws Exception
     */
    public static String generateToken(Map<String, Object> map, String secret, int expireMinutes) {

        try {
            final Date createdDate = new Date();
            return Jwts.builder()
                    .setClaims(map)
                    .setIssuedAt(createdDate)
                    .setExpiration(DateTime.now().plusMinutes(expireMinutes).toDate())
                    .signWith(getKeyInstance(secret))
                    .compact();
        } catch (Exception e) {
            throw new BizException(BizExceptionCommonEnum.TOKEN_GENERATE_ERRER);
        }
    }


    /**
     * 公钥解析token
     *
     * @param token 用户请求中的token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

    }

    /**
     * 获取token中的用户信息
     *
     * @param token 用户请求中的令牌
     * @return 用户信息
     * @throws Exception
     */
    public static Map<String, Object> getInfoFromToken(String token, String secret) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, secret);
        return claimsJws.getBody();
    }


}