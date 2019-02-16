package com.imooc.security.core.properties;

/**
 * Created by 吴猛
 * Date:2019/2/14
 */
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
    private SmsCodeProperties sms = new SmsCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
