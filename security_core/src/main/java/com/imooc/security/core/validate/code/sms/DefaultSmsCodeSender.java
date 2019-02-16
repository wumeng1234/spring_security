package com.imooc.security.core.validate.code.sms;/**
 * Created by 吴猛
 * Date:2019/2/14
 */
public class DefaultSmsCodeSender implements  SmsCodeSender{
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号为:"+mobile+"发送验证码:"+code);
    }
}
