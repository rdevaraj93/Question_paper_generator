package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.Service.QuestionService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;
import com.example.demo.dto.UserLoginBean;


@RestController
@RequestMapping("/question/")
public class QuestionController {

	@Autowired
	QuestionService questionservice;
	
	@GetMapping("/getallquestion/")
	public List<QuestionListViewEntiry> getAllQuestionList() {
		return questionservice.getAllQuestionlist();

	}
	
	@GetMapping("/getquestionbyid/{questionid}")
	public List<QuestionListViewEntiry> getQuestionById(@PathVariable Integer questionid ) {
		return questionservice.getQuestionById(questionid);

	}
	
	@PostMapping("/addquestion/")
	public ProcedureOutputResponceBean questionAdd(@RequestBody QuestionAddOrUpdateBean questionaddorupdatebean) {
		return questionservice.questionAddOrUpdate(questionaddorupdatebean);
	
	}
	
	@PutMapping("/updatequestion/")
	public ProcedureOutputResponceBean questionUpdate(@RequestBody QuestionAddOrUpdateBean questionaddorupdatebean) {
		return questionservice.questionAddOrUpdate(questionaddorupdatebean);
	
	}
	
	
	
	
}
