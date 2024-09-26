package com.example.bagStrap.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bagStrap.model.User;

@Mapper
public interface JoinMapper {

	List<User> joinList(HashMap<String, Object> map);
	
	void joinInsert(HashMap<String, Object> map);
	
	int joinMultiCheck(HashMap<String, Object> map);
	
	int nickNameMultiCheck(HashMap<String, Object> map);
	
	/*주소추가*/
	void addressInsert(HashMap<String, Object> map);
	
	User myInfoList(HashMap<String, Object> map);
	
	User myInfoAddress(HashMap<String, Object> map);
}
