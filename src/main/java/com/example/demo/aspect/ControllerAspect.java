package com.example.demo.aspect;

import com.example.demo.model.ResponseModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Aspect
public class ControllerAspect {
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    private void controllerRun() {
    }

    @Around("controllerRun()")

    public ResponseEntity controllerRunProcess(ProceedingJoinPoint pjp) throws Throwable {
        // 取得AOP參數
        Object[] args = pjp.getArgs();

            Object response = pjp.proceed(args);
            if(response == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            ResponseModel result = new ResponseModel(HttpStatus.OK.value(),"", response);
            return  new ResponseEntity<>(result, HttpStatus.OK);
    }
}
