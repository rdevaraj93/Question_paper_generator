package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionPaperGeneraterService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;

@RestController
@RequestMapping("/generate/")
public class QuestionPaperGeneraterController {
	
	@Autowired
	QuestionPaperGeneraterService questionpapergeneraterservice;
	
	@PostMapping("/newquestionpaper")
	public ProcedureOutputResponceBean generateNewQuestionPaper(@RequestBody QuestionPaperAddOrDeleteBean questionpaperaddordeletebean) { 
		System.out.println(" total unites {" + questionpaperaddordeletebean.getUnitIDList());
		return questionpapergeneraterservice.generateNewQuestionPaper(questionpaperaddordeletebean);
	}
}
