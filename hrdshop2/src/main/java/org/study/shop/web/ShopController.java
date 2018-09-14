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
	 * �ش� �Լ��� ȸ������� ��û�ϴ� �Լ��̴�.
	 * 
	 * @return ȸ����� ������ �̵�
	 */
	@RequestMapping(value = "/register" , method=RequestMethod.GET)
	public String register() {
		logger.info("/register  get called");
		
		return "shop/registerForm";
	}
	
	/**
	 * 
	 * 
	 * @param member : member��ü(ȸ���� ���̵�, �н�����, �̸�, ��������)�� �Է� �޾� �ҷ��´�
	 * @param rttr
	 * @return ȸ������Ʈ �������� �����Ѵ�.
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
	 * @param model ��ü�� �Է¹޴´�.
	 * @return �ѿ� ����Ʈ �������� �̵��Ѵ�.
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
