package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 吴猛
 * Date:2019/2/14
 */
public interface ValidateCodeGenerator {
    ValidateCode generator(ServletWebRequest request);

}
