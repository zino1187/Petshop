package com.pet.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

//클라이언트의 모든 요청을 대상으로, 세션이 있는지 여부를
//체크할 공통코드로 사용할 예정
public class LoginCheckAspect {
	int count=0;
	
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		Object returnObj=null;
		
		Class target = joinPoint.getTarget().getClass();
		System.out.println("Target:"+ target.getName());
		
		//세션존재 여부 체크한다 
		Object[] args=joinPoint.getArgs();//매개변수들...
		
		HttpSession session=null;
		HttpServletRequest request=null;
		for(Object arg : args) {
			
			if(arg instanceof HttpServletRequest) {
				request=(HttpServletRequest)arg;
				session = request.getSession();
				//System.out.println("requestURI is "+request.getRequestURI().toString());
			}
		}
		
		if(request.getRequestURI().equals("/")  || request.getRequestURI().equals("/product/list")) {
			System.out.println("상품을 원하네요");
			returnObj=joinPoint.proceed();//원래의 메서드 호출!!
			System.out.println("타겟 객체의 메서드 호출 후 반환된 값은 : " + returnObj);
		}else {
			if(session !=null) {
				if(session.getAttribute("member")==null) {
					System.out.println("로그인하지 않았음. 딱 걸렷다");
					throw new RuntimeException("로그인하지 않았음. 딱 걸렷다");
				}else {
					System.out.println("로그인 상태임");
					returnObj = joinPoint.proceed();//원래의 메서드 호출!!
					System.out.println("타겟 객체의 메서드 호출 후 반환된 값은 : " + returnObj);
				}
			}
		}
		count++;
		System.out.println("count is "+count);
		
		return returnObj;
	}
}

