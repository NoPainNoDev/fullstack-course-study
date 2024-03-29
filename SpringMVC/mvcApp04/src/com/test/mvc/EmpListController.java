// #29. EmpListController.java
// - 사용자 정의 컨트롤러 클래스
// - 리스트 페이지 요청에 대한 액션 처리. (일반직원)
// - DAO 객체에 대한 의존성 주입(DI)을 위한 준비.
//   → 인터페이스 자료형 구성, settter 메소드 정의.


package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
//사용자 정의 컨트롤러 클래스를 구성한다.

public class EmpListController implements Controller
{
	private IEmployeeDAO dao;
	
	
	public void setDao(IEmployeeDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		// 세션 처리 과정 추가(로그인에 대한 확인 과정 추가)---------------------------------
		HttpSession session = request.getSession();
		
		// 로그인이 안된 상태에서 직접 페이지를 요청하는 상황
		if(session.getAttribute("name")==null)
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		// ---------------------------------세션 처리 과정 추가(로그인에 대한 확인 과정 추가)
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		try
		{
			employeeList = dao.empList();
			
			mav.addObject("employeeList", employeeList);
			
			mav.setViewName("EmpList");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}
}
