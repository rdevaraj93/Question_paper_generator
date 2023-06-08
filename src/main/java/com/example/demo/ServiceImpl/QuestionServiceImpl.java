package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.QuestionDAORepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Service.QuestionService;
import com.example.demo.Utils.Constants;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDAORepository questiondaorepository;
	
	
	@Autowired 
	QuestionRepository questionrepository;
	
	@Override
	public ProcedureOutputResponceBean questionAddOrUpdate(QuestionAddOrUpdateBean questionaddorupdatebean) {
		return questiondaorepository.questionAddOrUpdate(questionaddorupdatebean);
	}

	@Override
	public ProcedureOutputResponceBean getAllQuestionlist() {
		
		System.out.println("Question controller");
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		List<QuestionListViewEntiry> questionlist = questionrepository.getAllQuestionlist();
			
			
			if (questionlist.size() > 0) {
				for (QuestionListViewEntiry questionEntity : questionlist) 
				{
					System.out.println("****************************");
					System.out.println("User Id "+questionEntity.getQuestionid());
					System.out.println("User dispalyname "+questionEntity.getQuestiondescription());
					System.out.println("User rollID "+questionEntity.getDepartmentName());
					System.out.println("User rollID "+questionEntity.getCreatedtimestamp());
						
					outputbean.setPo_new_id(Constants.SUCCESS_INTERGER_VALUE);
					outputbean.setPo_success_flag(Constants.SUCCESS_FLAG_VALUE);
					outputbean.setPo_message(Constants.SUCCESS);
				}
			}
			else
			{
				System.out.println("User doesn't exist");
				outputbean.setPo_new_id(Constants.FAILURE_INTERGER_VALUE);
				outputbean.setPo_success_flag(Constants.FAILURE_FLAG_VALUE);
				outputbean.setPo_message(Constants.FAILURE);
			}		
			
			return   outputbean;
			
		}

	@Override
	public ProcedureOutputResponceBean getQuestionById(Integer questionid) {
		
		System.out.println(" questionid ->" + questionid);
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		List<QuestionListViewEntiry> questionlist = questionrepository.getQuestionById(questionid);
			
			
			if (questionlist.size() > 0) {
				for (QuestionListViewEntiry questionEntity : questionlist) 
				{
					System.out.println("****************************");
					System.out.println("User Id "+questionEntity.getQuestionid());
					System.out.println("User dispalyname "+questionEntity.getQuestiondescription());
					System.out.println("User rollID "+questionEntity.getDepartmentName());
					System.out.println("User rollID "+questionEntity.getCreatedtimestamp());
						
					outputbean.setPo_new_id(Constants.SUCCESS_INTERGER_VALUE);
					outputbean.setPo_success_flag(Constants.SUCCESS_FLAG_VALUE);
					outputbean.setPo_message(Constants.SUCCESS);
				}
			}
			else
			{
				System.out.println("User doesn't exist");
				outputbean.setPo_new_id(Constants.FAILURE_INTERGER_VALUE);
				outputbean.setPo_success_flag(Constants.FAILURE_FLAG_VALUE);
				outputbean.setPo_message(Constants.FAILURE);
			}		
			
			return   outputbean;
	}

}