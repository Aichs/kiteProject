package org.aichs.kite.common.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: kite
 * @Package: org.aichs.kite.common.aop
 * @ClassName: RequestAspect
 * @Author: MECHREVO
 * @Description: aop处理
 * @Date: 2019/11/21 10:05
 */
@Aspect
@Component
public class RequestAspect {

    /** 日志监听 */
    private static Logger log = LogManager.getLogger(RequestAspect.class);

    /** 定义切点 */
    @Pointcut("execution(public * org.aichs.kite.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        
        // 监听入参以及访问请求
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        // 获取参数
        MethodSignature ms =(MethodSignature) joinPoint.getSignature();
        String[] paramenterNames = ms.getParameterNames();
        Object[] args = joinPoint.getArgs();

        Map<String,Object> map =new HashMap<>(16);
        
        for (int i =0;i<paramenterNames.length;i++){
            map.put(paramenterNames[i],args[i]);
        }
        
        log.info("url={},methodType={},ip={}, \nmethod={}, \nargs={}",
                request.getRequestURL(),
                request.getMethod(),
                request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName(),
                map);
    }
}
