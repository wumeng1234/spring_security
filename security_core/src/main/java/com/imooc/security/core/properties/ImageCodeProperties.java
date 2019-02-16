package com.imooc.security.core.properties;

import sun.security.util.Length;

/**
 * Created by 吴猛
 * Date:2019/2/14
 */
public class ImageCodeProperties extends SmsCodeProperties{
    private int width = 90;
    private int height = 23;
    public ImageCodeProperties() {
        setLength(4);
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
