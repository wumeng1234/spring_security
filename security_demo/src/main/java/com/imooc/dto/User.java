package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by 吴猛
 * Date:2019/1/28
 */
public class User {
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    private String id;
    @ApiModelProperty (value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty (value = "性别")
    private String sex;

    @MyConstraint(message = "密码已存在")
    @ApiModelProperty (value = "密码")
    private String password;

    @Past(message = "出生日期不能大于当前时间")
    @ApiModelProperty (value = "生日")
    private Date birthday;

    public User(String username, String sex, String password) {
        this.username = username;
        this.sex = sex;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
