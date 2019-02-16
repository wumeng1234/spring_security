package com.imooc.web.aspect;
import com.imooc.dto.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Date;
/**
 * Created by 吴猛
 * Date:2019/1/30
 */
//@Aspect
//@Component
public class TimeAspect {
    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入切面");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("在切面中获取到的参数为" + arg);
        }
        long start = new Date().getTime();
        Object obj = pjp.proceed();
        System.out.println("切面执行的时间为：" + (new Date().getTime() - start));
        return obj;
    }
}
