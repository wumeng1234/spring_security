package com.imooc.security.core.social.qq.connet;
import com.imooc.security.core.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * Created by 吴猛
 * Date:2019/2/15
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ>{
    public QQConnectionFactory(String providerId,String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret),new  QQAdapter());
    }
}
