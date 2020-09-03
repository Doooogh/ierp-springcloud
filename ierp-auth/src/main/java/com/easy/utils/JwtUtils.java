package com.easy.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/26 16:34
 * @Version 1.0
 **/
@Slf4j
public class JwtUtils {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

   /* private String secret="mall-admin-secret";
    private Long expiration=1L*60;
    private String tokenHead="Authorization";*/
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;



    //获取token  参数
    public String getToken(String username){
        Map<String, Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, username);
        claims.put(CLAIM_KEY_CREATED, new Date());
            return Jwts.builder()
                    .setClaims(claims)  //面向的对象
                    .setExpiration(generateExpirationDate()) //过期时间
                    .signWith(SignatureAlgorithm.HS512, secret) //加密
                    .compact();
        }

    /**
     * 从token中获取JWT中的负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims=e.getClaims();
            log.error("JWT格式验证失败:{已经过期}", token);
        }
        return claims;
    }

    /**
     * 从token中获取登录用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        if( username.equals(userDetails.getUsername()) && !isTokenExpired(token)){
            //更新token过期时间  防止在请求的时候赶上token正好过期   用户体验不好
            refreshHeadToken(token);
            return true;
        }
        return false;
    }

    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }


    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param
     */
    public String refreshHeadToken(String token) {
        if(StrUtil.isEmpty(token)){
            return null;
        }
        if(StrUtil.isEmpty(token)){
            return null;
        }
        //token校验不通过
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return null;
        }
        //如果token已经过期，不支持刷新
        if(isTokenExpired(token)){
            return null;
        }
        //如果token在30分钟之内刚刷新过，返回原token
        if(tokenRefreshJustBefore(token,30*60)){
            return token;
        }else{
            return getToken(claims.getSubject());
        }
    }

    /**
     * 判断token在指定时间内是否刚刚刷新过
     * @param token 原token
     * @param time 指定时间（秒）
     */
    private boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        if(refreshDate.after(created)&&refreshDate.before(DateUtil.offsetSecond(created,time))){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        JwtUtils jwtUtils = new JwtUtils();
    /*    String token = jwtUtils.getToken("test");
        System.out.println(token);*/
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiY3JlYXRlZCI6MTU5NjAxMzY0MDUzMSwiZXhwIjoxNTk2MDEzNzAwfQ.FG5hT3lOyOLl9y1tJVdyO3MVBAAHOrM_3CNZJjUotXQHK3NuB03Bwl6Dlyu6kJ7CD9j5wNbVFA4Fi8jRZYhoWg";
//        eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiY3JlYXRlZCI6MTU5NjAxMzI0MjMxNSwiZXhwIjoxNTk2MDEzMjUyfQ.58rA1vVtbW7_xPt16Cxj8eAGqzibvyTsuGqeBEmtfD-EZ-UIF2uZQSJJqN4DEzRFk5EdzG_SBHxtWLc3s9MpOg

        System.out.println("____________token中获取JWT中的负载_______________");
        Claims claimsFromToken = jwtUtils.getClaimsFromToken(token);
        System.out.println(claimsFromToken);
        System.out.println("_______________从token中获取登录用户名____________");
        System.out.println(jwtUtils.getUserNameFromToken(token));
        System.out.println("______________判断token是否已经失效_____________");
        System.out.println(jwtUtils.isTokenExpired(token));
        System.out.println("_________________过期时间__________");
        System.out.println(jwtUtils.getExpiredDateFromToken(token));
    }
}
