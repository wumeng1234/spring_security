package com.imooc.exception;

/**
 * Created by 吴猛
 * Date:2019/1/29
 */
public class UserNotExsitException extends RuntimeException {
    private String id;

    public UserNotExsitException(String id) {
        super("user is not fount");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
