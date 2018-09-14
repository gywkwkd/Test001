package org.study.shop.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.study.shop.dao.ShopDAO;
import org.study.shop.model.Member;


@Controller
public class ShopController {
	
	
	/**
	 *  @author user
	 */
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	
	@Autowired
	private ShopDAO dao;

	/**
	 * 해당 함수는 회원등록을 요청하는 함수이다.
	 * 
	 * @return 회원등록 페이지 이동
	 */
	@RequestMapping(value = "/register" , method=RequestMethod.GET)
	public String register() {
		logger.info("/register  get called");
		
		return "shop/registerForm";
	}
	
	/**
	 * 
	 * 
	 * @param member : member객체(회원의 아이디, 패스워드, 이름, 가입일자)를 입력 받아 불러온다
	 * @param rttr
	 * @return 회원리스트 페이지를 리턴한다.
	 */
	
	@RequestMapping(value = "/register" , method=RequestMethod.POST)
	public String registerProc(Member member, RedirectAttributes rttr) {
		logger.info("/register  post called");
		
		logger.info("member: " + member );
		try {
			dao.create(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "shop/list";
				
	}
	
	/**
	 * 
	 * @param model 객체를 입력받는다.
	 * @return 훼원 리스트 페이지로 이동한다.
	 */
	@RequestMapping("/list")
	public String listAll(Model model) {
		try {
			List<Member> list = dao.listAll();
			model.addAttribute("list",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "shop/list";
	}
	
}
