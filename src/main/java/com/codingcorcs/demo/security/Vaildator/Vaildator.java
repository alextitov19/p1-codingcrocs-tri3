package com.codingcorcs.demo.security.Vaildator;

import com.codingcorcs.demo.NewUser.NewUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class Vaildator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
