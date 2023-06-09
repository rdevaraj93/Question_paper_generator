package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;

public interface QuestionService {
	
	public ProcedureOutputResponceBean questionAddOrUpdate(QuestionAddOrUpdateBean questionaddorupdatebean);

	public List<QuestionListViewEntiry> getAllQuestionlist();

	public List<QuestionListViewEntiry> getQuestionById(Integer questionid);
	 
	
}
