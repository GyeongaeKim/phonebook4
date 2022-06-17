package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController{
	
	//필드
	@Autowired
	private PhoneService phoneService;	//=new PhoneDao() 주입할 필요없음!! 
	//Dao에는 @Repository붙였고, 여기서는 Autowired붙였기 때문 
	
			
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//1. 전화번호 리스트
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list()");
		
		//Dao - getPersonList 꺼내오기
		//Service를 통해서 personList(주소)를 가져온다 ***
		//PhoneService phoneService = new PhoneService();
		////PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneService.getPersonList();
		
		//Model을 통해, DispatcherServlet에게 데이터 보내기(request attribute에 넣는다)
		model.addAttribute("personList", personList);
		
		//포워드-뷰리졸버 사용하여 간단하게 포워드 가능
		return "list";
	}
	
	
	
	
	//2. 전화번호 등록 폼
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		
		return "writeForm";
	}
	
	//등록메소드
	//3. 전화번호 등록***
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write()");

		// Service를 통해서 저장한다
		//int count = phoneService.personInsert(personVo);
		int count = phoneService.personInsert2();

		// 리다이렉트
		return "redirect:/list";
	}
	
	
	//전화번호 등록2(파라미터를 하나씩 꺼내는 경우)
	/*
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name, 
						@RequestParam("hp") String hp, 
						@RequestParam("company") String company) {
		System.out.println("PhoneController>write()");
		
		//파라미터 꺼내기
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		
		
		//vo로 묶기
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		//dao로 저장하기
		//PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		
		//리다이렉트
		//리스트로 리다이렉트 시킬 예정(포워드 x)
		return "redirect:/list";
	}
	*/
	
	
	
	//4. 전화번호 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhoneController>delete()");

		// Service를 통해서 삭제한다
		int count = phoneService.personDelete(no);

		return "redirect:/list";
	}
	
	/*
	@RequestMapping(value="/delete2", method={RequestMethod.GET, RequestMethod.POST})
	public String delete2(@RequestParam("no") int no) {
		System.out.println("PhoneController>delete()");
		
		//파라미터 꺼내기
		System.out.println(no);
		
		
		//Dao로 처리하기(삭제)
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personDelete(no);
		
		System.out.println(count);
		
		return "redirect:/list";
	}
	*/
	
	
	
	
	
	//5. 전화번호 수정폼
	@RequestMapping(value="/updateForm", method={RequestMethod.GET, RequestMethod.POST})
	public String updateForm() {
		System.out.println("PhoneController>updateForm()");
		
		return "updateForm";
	}
	
	
	//***. 전화번호 수정폼2
	@RequestMapping(value="/updateForm2", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm2(Model model, @RequestParam("no") int no) {
		System.out.println("PhoneController>updateForm2()");
		
		Map<String, Object> pMap = phoneService.getPerson2(no);
		
		model.addAttribute("pMap", pMap);
		
		return "updateForm2";
	}
	
	
	//6. 전화번호 수정
	@RequestMapping(value="/update", method={RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update()");
		
		//PhoneDao personUpdate()로 수정하기
		//PhoneDao phoneDao = new PhoneDao();
		int count = phoneService.personUpdate(personVo);
		System.out.println(count);
		
		//리다이렉트 list
		return "redirect:/list";
	}
	
	
	
	
	
	//테스트
	/*
	@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST}) //(value="", method="")
	
	public String test() {
		System.out.println("PhoneController>test()");
		
		return "test";
	} 
	*/
}
