package org.study.shop.dao;

import java.util.List;

import org.study.shop.model.Member;

public interface ShopDAO {
	
	public void create(Member member)throws Exception;
	
	
	public List<Member> listAll() throws Exception;
	
	

}
