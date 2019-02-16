package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by 吴猛
 * Date:2019/1/29
 * 自定义检验
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object>{

    @Autowired
    HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.hello("wumeng");
        System.out.println(o);
        return false;
    }
}
