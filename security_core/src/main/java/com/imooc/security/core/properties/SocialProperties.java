package com.imooc.security.core.properties;/**
 * Created by 吴猛
 * Date:2019/2/15
 */
public class SocialProperties {
    QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
