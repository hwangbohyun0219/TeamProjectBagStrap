package com.example.bagStrap.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bagStrap.dao.SharedHeaderService;
import com.google.gson.Gson;

@Controller
public class SharedHeaderController {

	@Autowired
	SharedHeaderService sharedHeaderService;

	@RequestMapping("/myStudy.do")
	public String main(Model model) throws Exception {
		return "/sharedHeader/myStudy";
	}

	@RequestMapping(value = "/myStudy.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myStudy(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		System.out.println(map);
		HashMap<String, Object> resultMap = new HashMap();


		return new Gson().toJson(resultMap);
	}

}
