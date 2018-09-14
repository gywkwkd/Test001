package org.study.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.shop.model.Member;

@Repository
public class ShopDAOImpl implements ShopDAO {

	private static final String namespace = "org.study.mapper.ShopMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void create(Member member) throws Exception {
		
		session.insert(namespace + ".create", member);
	}

	@Override
	public List<Member> listAll() throws Exception {
	return session.selectList(namespace + ".listAll");
		
	}

}
