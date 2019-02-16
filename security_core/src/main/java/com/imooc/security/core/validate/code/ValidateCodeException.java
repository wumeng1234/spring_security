package com.imooc.security.core.validate.code;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by 吴猛
 * Date:2019/2/13
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}


