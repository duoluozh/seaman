package com.lhh.seamanrecruit.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: yslong
 * @Date: 2022/4/9 14:03
 * @Description: jwt工具类
 */
@Slf4j
@Component
public class JwtUtils {
    // 创建默认的秘钥和算法，供无参的构造方法使用
    /**
     * 默认的秘钥
     */
    private static final String DEFAULT_BASE64_ENCODED_SECRET_KEY = "lhh";
    /**
     * 算法
     */
    private static final SignatureAlgorithm DEFAULT_SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    public JwtUtils() {
        // 调用本类的构造方法
        this(DEFAULT_BASE64_ENCODED_SECRET_KEY, DEFAULT_SIGNATURE_ALGORITHM);
    }

    private final String base64EncodedSecretKey;
    private final SignatureAlgorithm signatureAlgorithm;

    public JwtUtils(String secretKey, SignatureAlgorithm signatureAlgorithm) {
        // 这样给成员变量赋值是为了让成员方法也能使用
        this.base64EncodedSecretKey = Base64.encodeBase64String(secretKey.getBytes());
        this.signatureAlgorithm = signatureAlgorithm;
    }


    /**
     * 生成jwt令牌(token)
     * @param issuer 签发人，一般都是username或者userId
     * @param ttlMillis 过期时间
     * @param claims 想要在jwt中存储的一些非隐私信息
     * @return
     */
    public String getToken(String issuer, long ttlMillis, Map<String, Object> claims) {
        if (claims == null) {
            claims = new HashMap<>();
        }
        long nowMillis = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder().setClaims(claims)
                // 1.这个是JWT的唯一标识，一般设置成唯一的，这个方法可以生成唯一标识
                .setId(UUID.randomUUID().toString())
                // 2. 这个地方就是以毫秒为单位，换算当前系统时间生成的iat
                .setIssuedAt(new Date(nowMillis))
                // 3. 签发人，也就是JWT是给谁的（逻辑上一般都是username或者userId）
                .setSubject(issuer)
                // 这个地方是生成jwt使用的算法和秘钥
                .signWith(signatureAlgorithm, base64EncodedSecretKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            // 4. 过期时间，这个也是使用毫秒生成的，使用当前时间+前面传入的持续时间生成
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 相当于encode的方向，传入jwtToken生成对应的username和password等字段。Claim就是一个map
     * 也就是拿到荷载部分所有的键值对
     *
     * @param jwtToken
     * @return
     */
    public Claims decode(String jwtToken) {

        // 得到 DefaultJwtParser
        return Jwts.parser()
                // 设置签名的秘钥使用成员变量的值
                .setSigningKey(base64EncodedSecretKey)
                // 设置需要解析的 jwt
                .parseClaimsJws(jwtToken).getBody();
    }



    /**
     * 判断jwtToken是否合法
     */
    public boolean isVerify(String jwtToken) {
        // 这个是官方的校验规则，这里只写了一个”校验算法“，可以自己加
        Algorithm algorithm = null;
        switch (signatureAlgorithm) {
            case HS256:
                algorithm = Algorithm.HMAC256(Base64.decodeBase64(base64EncodedSecretKey));
                break;
            default:
                throw new RuntimeException("不支持该算法");
        }
        JWTVerifier verifier = JWT.require(algorithm).build();
        // 校验不通过会抛出异常
        try {
            verifier.verify(jwtToken);
        } catch (JWTVerificationException e) {
            return false;
        }
        // 判断合法的标准：1. 头部和荷载部分没有篡改过。2. 没有过期
        return true;
    }

    public static void main(String[] args) {
        JwtUtils jwtUtils = new JwtUtils("tom", SignatureAlgorithm.HS256);
        // 以tom作为秘钥，以HS256加密
        Map<String, Object> map = new HashMap<>();
        map.put("username", "tom");
        map.put("password", "123456");
        map.put("age", 20);
        String jwtToken = jwtUtils.getToken("tom", 30000, map);
        System.out.println(jwtToken);
        boolean verify = jwtUtils.isVerify("jwtToken");
        System.out.println(verify);

        jwtUtils.decode(jwtToken).entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }

}
