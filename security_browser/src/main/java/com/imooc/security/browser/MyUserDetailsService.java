package com.imooc.security.browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
/**
 * Created by 吴猛
 * Date:2019/2/11
 * 自定义认证
 * 需实现spring提供的UserDetailsService接口，重写接口的loadUserByUsername方法
 */
@Component
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService{
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名为：" + username);
        return builder(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录用户ID：" + userId);
        return builder(userId);
    }

    public SocialUserDetails builder(String userId){
        //根据用户名或用户id查找用户信息,并根据查找到的信息判断用户是否被冻结
        return new SocialUser(userId, passwordEncoder.encode("123456"),
                true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
