package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//1. 전체리스트
	public List<PersonVo> getPersonList() {
		System.out.println("PhoneDao>getPersonList()");
		return sqlSession.selectList("phonebook.selectList");
		//List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");	// ("namespace.id")
		//return personList;
	}
	
	
	//2. 사람추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneDao>personInsert()");
		return sqlSession.insert("phonebook.personInsert", personVo);
		//int count = sqlSession.insert("phonebook.personInsert", personVo);
		//return count;
	}
	
	
	//*. 사람추가2 Map사용
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("PhoneDao>personInsert2()");
		
		//System.out.println(pMap.toString());
		
		int count = sqlSession.insert("phonebook.personInsert2", pMap );
		
		return 1;
	}
	
	
	//3. 사람 삭제
	public int personDelete(int no) {
		System.out.println("PhoneDao>personDelete()");
		int count = sqlSession.delete("phonebook.personDelete", no);
		return count;
	}
	
	//4. 수정폼(정보 가져오기)
	public PersonVo getPerson(int no) {
		System.out.println("PhoneDao>getPerson()");
		return  sqlSession.selectOne("phonebook.getPerson", no);
	}
	
	//4*. 수정폼2(정보 가져오기)	-map사용
	public Map<String, Object> getPerson2(int no) {
		System.out.println("PhoneDao>getPerson2()");
		System.out.println(no);
		
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.getPerson2", no);

		return pMap;
	}
	
	//5. 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao>personUpdate()");
		return sqlSession.update("phonebook.personUpdate", personVo);
	}
	

	
}