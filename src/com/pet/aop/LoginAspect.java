package com.pet.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.pet.domain.Member;

public class LoginAspect {
	
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result=null;
		
		Object[] args=joinPoint.getArgs();
		
		
		HttpServletRequest request=null;
		//요청 객체 추출
		Member member=null;
		
		for(Object obj : args) {
			if(obj instanceof HttpServletRequest) {
				request=(HttpServletRequest)obj;
				System.out.println("uri is "+request.getRequestURI());
				/*
				member=(Member)request.getSession().getAttribute("member");
				
				//로그인 아이디 존재 여부 체크 
				if(member!=null) {
					result = joinPoint.proceed();
				}else if(!request.getRequestURI().equals("/main")) {
					
					request.setAttribute("msg", "로그인이 필요한 서비스입니다");
					result="view/error";
				}
				*/
			}
		}
		joinPoint.proceed();
		//System.out.println("result is "+result);
		return result;
	}
}





