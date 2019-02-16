package com.imooc.code;
import com.imooc.security.core.validate.code.ValidateCode;
import com.imooc.security.core.validate.code.image.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 吴猛
 * Date:2019/2/14
 */
//@Component("imageCodeGenerator")
public class DemoImageGenerator implements ValidateCodeGenerator{

    @Override
    public ValidateCode generator(ServletWebRequest request) {
        System.out.println("自定义的图形验证码生成器");
        return null;
    }
}
