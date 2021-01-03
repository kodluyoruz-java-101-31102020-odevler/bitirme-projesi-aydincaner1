package com.bitirme.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.bitirme.springboot.annotation.RunTime;

@Aspect
@Component
public class MethodExecTimeAspect {
	
	    @Around("@annotation(runTime)")
	    public Object execute(ProceedingJoinPoint joinPoint, RunTime runTime) throws Throwable {

	        if (!runTime.active()) {
	            return joinPoint.proceed();
	        }
//yorum
	        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
	        String methodName = joinPoint.getSignature().getName();

	        StopWatch stopWatch = new StopWatch();

	        stopWatch.start();

	        Object result;
	        result = joinPoint.proceed();

	        stopWatch.stop();

	        System.out.println("Class name -> " + className +  "  Method name : " + methodName + " Run Time-> " + stopWatch.getTotalTimeMillis() + "ms. ");

	        return result;
	    }

}
