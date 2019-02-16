package com.imooc.security.core.validate.code.sms;/**
 * Created by 吴猛
 * Date:2019/2/14
 */
public interface SmsCodeSender {
    void send(String mobile,String code);
}
