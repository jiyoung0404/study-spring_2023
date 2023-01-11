package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//주소만 치고 들어왔을때 home 메소드를 사용하겠다
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
		System.out.println("home");
		//	return "/WEB-INF/views/index.jsp";
		// 중독되는 부분을 제외할수있다 servlet-context에서 설정 prefix,suffix
		return "index";
	}
	
	
	
	@RequestMapping(value = "/test1",method = RequestMethod.GET)
	public String test1() {
		System.out.println("test1");
		return null;
	}
}
