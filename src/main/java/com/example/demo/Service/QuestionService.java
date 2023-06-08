package com.example.demo.Service;

import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;

public interface QuestionService {
	
	public ProcedureOutputResponceBean questionAddOrUpdate(QuestionAddOrUpdateBean questionaddorupdatebean);

	public ProcedureOutputResponceBean getAllQuestionlist();

	public ProcedureOutputResponceBean getQuestionById(Integer questionid);
	 
	
}
