package com.imooc.security.browser.support;/**
 * Created by 吴猛
 * Date:2019/2/11
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
