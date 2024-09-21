package com.example.bagStrap.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.bagStrap.dao.StudyService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudyController {
	
	@Autowired
	StudyService studyService; 
	@Autowired
	HttpSession session;
	
	@RequestMapping("/defaultView") 
    public String defaultView(Model model) throws Exception{
         return "study/defaultView";
    }
	@RequestMapping("/study") 
    public String mainz(Model model) throws Exception{
         return "study/study_home";
    }
	// 스터디 커뮤니티 메인
	@RequestMapping("/study-comm") 
	 public String study_comm(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("boardTypeId2", map.get("boardTypeId2"));
		 request.setAttribute("name2", map.get("name"));
		return "/study/study-comm";
	}
	// 스터디 커뮤니티 게시글 상세보기 
	@RequestMapping("/study-comm-detail") 
	 public String study_comm_default(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("boardId", map.get("boardId"));
       return "/study/study-comm-detail";
	}       
	// 스터디 커뮤니티 나의 게시글, 댓글 
	@RequestMapping("/study-comm-myboard") 
    public String study_comm_myboard(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("itemMode", map.get("itemMode"));
		return "study/study-comm-myboard";
    }
	// 스터디 커뮤니티 게시글 작성
	@RequestMapping("/commInsert") 
    public String commInsert(Model model) throws Exception{
         return "study/study-comm-insert";
    }
	
	        
	@RequestMapping(value = "/study.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String study(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		System.out.println(map);
		HashMap<String, Object> resultMap = new HashMap();


		return new Gson().toJson(resultMap);
	}
	
	//스터디 커뮤니티 사이드바 카테고리 타입 (사이드바)
	@RequestMapping(value = "/selectStuCommType.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectStuCommType(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectStuComm(map);
		return new Gson().toJson(resultMap);
	}
	
	//스터디 커뮤니티 리스트
	@RequestMapping(value = "/selectStuCommListBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectStuCommListBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectStuCommListBoard(map);
		return new Gson().toJson(resultMap);
	}
	//스터디 사이드바 나의 게시글, 댓글 목록 개수 (사이드바)
	@RequestMapping(value = "/sidebarCnt.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String sidebarCnt(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.sidebarCnt(map);
		return new Gson().toJson(resultMap);
		}
	//스터디 커뮤니티 디테일 나의 게시글, 댓글 목록 개수
	@RequestMapping(value = "/myCnt.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myCnt(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.myCnt(map);
		return new Gson().toJson(resultMap);
		}
	//스터디 커뮤니티 상세 글 
	@RequestMapping(value = "/selectCommView.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectCommView(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectCommView(map);
		return new Gson().toJson(resultMap);
	}
	//스터디 커뮤니티 상세 글 - 댓글작성
		@RequestMapping(value = "/insertViewComment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertViewComment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			System.out.println(map);
			resultMap = studyService.insertViewComment(map);
			return new Gson().toJson(resultMap);
		}
	//스터디 커뮤니티 게시글 작성 하기 - 카테고리 불러오기 
	@RequestMapping(value = "/selectMyCommCategory.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectMyCommCategory(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectMyCommCategory(map);
		return new Gson().toJson(resultMap);
	}
	//스터디 커뮤니티 게시글 작성 하기 
	@RequestMapping(value = "/insertComm.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String insertComm(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.insertComm(map);

		return new Gson().toJson(resultMap);
	}
	
	//스터디 커뮤니티 게시글 숨기기 
	@RequestMapping(value = "/updateStatusBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateStatusBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.updateStatusBoard(map);

		return new Gson().toJson(resultMap);
	}
		
	//스터디 게시글 작성하기 이미지 첨부
	 @RequestMapping("/fileUpload.dox")
	    public String result(@RequestParam("file1") MultipartFile multi, @RequestParam("idx") int idx, HttpServletRequest request,HttpServletResponse response, Model model)
	    {
	        String url = null;
	        String path=System.getProperty("user.dir");
	        try {
	 
	            //String uploadpath = request.getServletContext().getRealPath(path);
	            String uploadpath = path;
	            String originFilename = multi.getOriginalFilename();
	            String extName = originFilename.substring(originFilename.lastIndexOf("."),originFilename.length());
	            long size = multi.getSize();
	            String saveFileName = genSaveFileName(extName);
	            
	            System.out.println("uploadpath : " + uploadpath);
	            System.out.println("originFilename : " + originFilename);
	            System.out.println("extensionName : " + extName);
	            System.out.println("size : " + size);
	            System.out.println("saveFileName : " + saveFileName);
//	            String path2 = System.getProperty("user.dir");
	            System.out.println("Working Directory = " + path + "\\src\\webapp\\img");
	            if(!multi.isEmpty()){
	                File file = new File(path + "\\src\\main\\webapp\\src", saveFileName);
	                multi.transferTo(file);
	                
	                HashMap<String, Object> map = new HashMap<String, Object>();
	                map.put("fileName", saveFileName);
	                map.put("filePath", "../src/" + saveFileName);
	                map.put("idx", idx);
	                map.put("fileOrgName", originFilename);
	                map.put("fileSize", size);
	                map.put("fileExt", extName);
	                // insert 쿼리 실행         
	                studyService.addBoardFile(map);
	                
	                model.addAttribute("filename", multi.getOriginalFilename());
	                model.addAttribute("uploadPath", file.getAbsolutePath());
	                
	                return "redirect:/study-comm";
	            }
	        }catch(Exception e) {
	            System.out.println(e);
	        }
	        return "redirect:/study-comm";
	    }
	    
	    // 현재 시간을 기준으로 파일 이름 생성
	    private String genSaveFileName(String extName) {
	        String fileName = "";
	        
	        Calendar calendar = Calendar.getInstance();
	        fileName += calendar.get(Calendar.YEAR);
	        fileName += calendar.get(Calendar.MONTH);
	        fileName += calendar.get(Calendar.DATE);
	        fileName += calendar.get(Calendar.HOUR);
	        fileName += calendar.get(Calendar.MINUTE);
	        fileName += calendar.get(Calendar.SECOND);
	        fileName += calendar.get(Calendar.MILLISECOND);
	        fileName += extName;
	        
	        return fileName;
	    }
	  //스터디 커뮤니티 게시글 삭제 하기 
		@RequestMapping(value = "/deleteBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deleteBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deleteBoard(map);

			return new Gson().toJson(resultMap);
		}
}