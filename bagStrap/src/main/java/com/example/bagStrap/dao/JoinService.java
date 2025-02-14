package com.example.bagStrap.dao;

import java.util.HashMap;
import java.util.List;

import com.example.bagStrap.model.User;

import jakarta.servlet.http.HttpSession;

public interface JoinService {
	
	HashMap<String, Object> searchJoin(HashMap<String, Object> map);
	
	HashMap<String, Object> addJoin(HashMap<String,Object> map);
	
	HashMap<String, Object> doubleCheckJoin(HashMap<String, Object> map);
	
	HashMap<String, Object> doubleNickName(HashMap<String, Object> map);
	
	HashMap<String, Object> addAddress(HashMap<String, Object> map);
	
	HashMap<String, Object> searchmyInfo(HashMap<String, Object> map);

	HashMap<String, Object> reloadAddress(HashMap<String, Object> map);
	
	HashMap<String, Object> updateNickName(HashMap<String, Object> map);
	
	HashMap<String, Object> QuitId(HashMap<String, Object> map);
	
	HashMap<String, Object> PasswordCheck(HashMap<String, Object> map);
	
	HashMap<String, Object> adminUsersCheck(HashMap<String, Object> map);
	
	HashMap<String, Object> updateAdminUsers(HashMap<String, Object> map);
	
	HashMap<String, Object> extraBanOut(HashMap<String, Object> map);
	//프로필
	HashMap<String, Object> insertJoinProFile (HashMap<String, Object> map);
	
	List<User> getUserList(int offset, int limit, String searchOption, String keyword);
    int getUserCount(String searchOption, String keyword);
	
}
