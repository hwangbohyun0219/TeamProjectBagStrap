package com.example.bagStrap.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bagStrap.mapper.StudyMapper;
import com.example.bagStrap.model.Item;
import com.example.bagStrap.model.StudyComm;

@Service
public class StudyServiceImpl implements StudyService{

	@Autowired
	StudyMapper studyMapper;


	@Override
	public HashMap<String, Object> searchItem(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap();
		
		try {

			
			resultMap.put("result", true);
			resultMap.put("message", "성공~");


			
		} catch(Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}


		
		return resultMap;
	}

	//스터디 커뮤니티 사이드 
	@Override
	public HashMap<String, Object> selectStuComm(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		
		try {
			List<StudyComm> boardTypelist = studyMapper.selectStuComm(map);
			List<StudyComm> boardList = studyMapper.selectStuCommList(map);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("boardTypelist", boardTypelist);
			resultMap.put("boardList", boardList);
			
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		
		return resultMap;
	}

	// 스터디 커뮤니티 컨텐츠 부문
	@Override
	public HashMap<String, Object> selectStuCommListBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			List<StudyComm> commlist = studyMapper.selectStuCommListBoard(map);
			int countCommList = studyMapper.countCommList(map);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("commlist", commlist);
			resultMap.put("cnt", countCommList);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 나의 댓글,게시글 목록 및 카운트
	public HashMap<String, Object> myCnt(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			int countMyCommList = studyMapper.countMyCommList(map);
			int countMycommentList = studyMapper.countMycommentList(map);
			List<StudyComm> selectMyComm = studyMapper.selectMyComm(map);
			List<StudyComm> selectMyComment = studyMapper.selectMyComment(map);
			resultMap.put("countMyCommCnt", countMyCommList);
			resultMap.put("countMycommentCnt", countMycommentList);
			resultMap.put("selectMyCommList", selectMyComm);
			resultMap.put("selectMyCommentList", selectMyComment);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
		
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 상세 글
	@Override
	public HashMap<String, Object> selectCommView(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			StudyComm selectCommView = studyMapper.selectCommView(map);
			List<StudyComm> selectViewComment = studyMapper.selectViewComment(map);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("viewList", selectCommView);
			resultMap.put("viewComment", selectViewComment);
		
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	@Override
	public HashMap<String, Object> sidebarCnt(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			int countMyCommList = studyMapper.countMyCommList(map);
			int countMycommentList = studyMapper.countMycommentList(map);
			resultMap.put("countMyCommCnt", countMyCommList);
			resultMap.put("countMycommentCnt", countMycommentList);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
		
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	
	//스터디 커뮤니티 상세 글 - 댓글작성
	@Override
	public HashMap<String, Object> insertViewComment(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertViewComment(map);
	
			resultMap.put("result", true);
			resultMap.put("message", "댓글 작성 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 게시글 작성하기 카테고리  
	@Override
	public HashMap<String, Object> selectMyCommCategory(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			List<StudyComm> selectMyCommCategory = studyMapper.selectMyCommCategory(map);
			resultMap.put("categoryList", selectMyCommCategory);
			resultMap.put("result", true);
			resultMap.put("message", "댓글 작성 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 게시글 작성
	@Override
	public HashMap<String, Object> insertComm(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertComm(map);
			resultMap.put("idx",map.get("board_Id"));
			resultMap.put("result", true);
			resultMap.put("message", "게시글 작성 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 게시글 이미지 첨부
	@Override
	public HashMap<String, Object> addBoardFile(HashMap<String, Object> map) {
		studyMapper.insertBoardFile(map);
		return null;
	}
	// 스터디 커뮤니티 게시글 삭제 
	@Override
	public HashMap<String, Object> deleteBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		try {
			studyMapper.deleteBoard(map);
			resultMap.put("result", true);
			resultMap.put("message", "게시글 삭제 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 게시글 숨기기 및 해제 
	@Override
	public HashMap<String, Object> updateStatusBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		try {
			studyMapper.updateStatusBoard(map);
			resultMap.put("resultHide",map.get("BOARD_STATUS"));
			resultMap.put("result", true);
			resultMap.put("message", "ㅋㅋㅋ");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> updateComm(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateComm(map);
			resultMap.put("idx",map.get("board_Id"));
			resultMap.put("result", true);
			resultMap.put("message", "게시글 업데이트 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}

	
	
}
