package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.exception.UserNotExsitException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴猛
 * Date:2019/1/28
 *
 * @RequestMapping(value = "/user",method = RequestMethod.GET)
 * @RequestMapping(value = "/user/{id:\\d+}",method = RequestMethod.GET )
 */
@RestController
@RequestMapping("/user")
public class UserController {

   private final  Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/me")
    public Authentication getMe(Authentication ahthentication) {
        return ahthentication;
    }

    //删除用户
    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    /**
     * 更新用户
     */
    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    //创建用户
    @PostMapping
    public User creat(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    //查询用户
    @JsonView(User.UserSimpleView.class)
    @GetMapping
    @ApiOperation(value = "用户查询服务")
    public List<User> query(User user, @PageableDefault(page = 1, size = 10, sort = "username,asc") Pageable pageable) {
        logger.info(user.toString());
        logger.info(String.valueOf(pageable.getPageNumber()));
        logger.info(String.valueOf(pageable.getPageSize()));
        logger.info(String.valueOf(pageable.getSort()));
        List<User> lists = new ArrayList<>();
        lists.add(new User("手机", "男", "123456"));
        lists.add(new User("电脑", "男", "123456"));
        lists.add(new User("平板", "男", "123456"));
        return lists;
    }

    //查询用户详情
    @JsonView(User.UserDetailView.class)
    @GetMapping(value = "/{id:\\d+}")
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
        //throw new UserNotExsitException(id);
        System.out.println(id);
        User user = new User("tom", "男", "1234");
        return user;
    }

}
