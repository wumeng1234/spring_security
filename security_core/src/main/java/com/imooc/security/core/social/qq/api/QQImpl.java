package com.imooc.security.core.social.qq.api;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import java.io.IOException;

/**
 * Created by 吴猛
 * Date:2019/2/15
 * 获取用户信息
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{
    //openid访问链接
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    //用户信息访问链接
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?&oauth_consumer_key=%s&openid=%s";

    private String appId;
    private  String openId;

    private ObjectMapper objectMapper = new ObjectMapper();

    //获取openid
    public QQImpl(String sccessToken,String appId) {
        super(sccessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID,sccessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    //获取用户信息
    @Override
    public QQUserInfo getUserInfo(){
        String url = String.format(URL_GET_USERINFO,appId,openId);
        //获取用户信息
        String result = getRestTemplate().getForObject(url,String.class);
        System.out.println(result);
        try {
            return objectMapper.readValue(result, QQUserInfo.class);
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败!");
        }
    }
}
