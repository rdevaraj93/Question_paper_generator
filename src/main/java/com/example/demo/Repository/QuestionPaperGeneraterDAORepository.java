package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.QuestionListViewEntiry;
import com.example.demo.QuestionPatten.ExamPatten;
import com.example.demo.QuestionPatten.QuestionPatten;
import com.example.demo.Utils.ExamQuestionProperty;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;


@Repository
public class QuestionPaperGeneraterDAORepository  extends DataBaseAdapter{

	
	@Autowired
	ExamPatten exampatten;
	
	@Autowired	
	QuestionPatten questionpatten;
	
	@Autowired 
	QuestionRepository questionrepository;
	
	@Autowired
	ExamQuestionProperty examquestionproperty;
	
	public List<QuestionListViewEntiry> randomQuestionList(List<QuestionListViewEntiry> questionlist, Integer questionCount){
		
		Random random = new Random();
		List<QuestionListViewEntiry> tempList = new ArrayList<>();  
		for (int i = 0; i < questionCount; i++) { 
	            int randomIndex = random.nextInt(questionlist.size());
	            while(tempList.contains(questionlist.get(randomIndex))) {
	            	randomIndex = random.nextInt(questionlist.size());
	            }
	            tempList.add(questionlist.get(randomIndex));     
	        } 
		 return tempList;
	}
	
	public List<Integer> mergerandomQuestionList(List<QuestionListViewEntiry> tempList, List<Integer> onemarkquestionlist){
			 
		if (tempList.size() > 0) {						
			for (QuestionListViewEntiry questionEntity : tempList) 
				{
					onemarkquestionlist.add(questionEntity.getQuestionid());		 
				}
		}
		 return onemarkquestionlist;
	}
	
	public ProcedureOutputResponceBean generateNewQuestionPaper(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean) {
		
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();		 	
		var required_exam_mark = questionpaperaddordeletebean.getTotalexammark();
		
		if (required_exam_mark == Integer.valueOf(examquestionproperty.getProperty_exam_is_ten_mark())) {
			System.out.println(" This is a ten mark");
		}
		else if (required_exam_mark == Integer.valueOf(examquestionproperty.getProperty_exam_is_twenty_mark()) ) {
			
			if (questionpaperaddordeletebean.getIssuppotoptional().equals('Y')) {
				System.out.println(" This is a 20 mark and support Optional");
			}else
			{
				System.out.println(" This is a 20 mark and won't support Optional question");
				List<Integer> finalQuestionIDList 	= new ArrayList<Integer>();
				 
				
				Integer	totalonemarkquestioncount_easy  	=  exampatten.getWithoutoptional().getTotaltwentymark().getOnemarkquestion().getEasy();
				Integer	totalonemarkquestioncount_medium  	=  exampatten.getWithoutoptional().getTotaltwentymark().getOnemarkquestion().getMedium();
				Integer	totalonemarkquestioncount_hard  	=  exampatten.getWithoutoptional().getTotaltwentymark().getOnemarkquestion().getHard();

				Integer	totaltwomarkquestioncount_easy 		=  exampatten.getWithoutoptional().getTotaltwentymark().getTwomarkquestion().getEasy();
				Integer	totaltwomarkquestioncount_medium 	=  exampatten.getWithoutoptional().getTotaltwentymark().getTwomarkquestion().getMedium();
				Integer	totaltwomarkquestioncount_hard 		=  exampatten.getWithoutoptional().getTotaltwentymark().getTwomarkquestion().getHard();
				
				Integer	totalfivemarkquestioncount_easy  	=  exampatten.getWithoutoptional().getTotaltwentymark().getFivemarkquestion().getEasy();
				Integer	totalfivemarkquestioncount_medium  	=  exampatten.getWithoutoptional().getTotaltwentymark().getFivemarkquestion().getMedium();
				Integer	totalfivemarkquestioncount_hard  	=  exampatten.getWithoutoptional().getTotaltwentymark().getFivemarkquestion().getHard();
				
				Integer	totaltenmarkquestioncount_easy		=  exampatten.getWithoutoptional().getTotaltwentymark().getTenmarkquestion().getEasy();
				Integer	totaltenmarkquestioncount_medium 	=  exampatten.getWithoutoptional().getTotaltwentymark().getTenmarkquestion().getMedium();
				Integer	totaltenmarkquestioncount_hard		=  exampatten.getWithoutoptional().getTotaltwentymark().getTenmarkquestion().getHard();
								
	
				//One mark
				List<QuestionListViewEntiry> questionEasylist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(), questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_one_mark_id());
				List<QuestionListViewEntiry> questionMediumlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_medium_id(), examquestionproperty.getProperty_one_mark_id());
				List<QuestionListViewEntiry> questionHardlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),	questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_hard_id(), examquestionproperty.getProperty_one_mark_id());
								 
				List<QuestionListViewEntiry> tempList = new ArrayList<>(); 
				
				tempList = randomQuestionList( questionEasylist ,totalonemarkquestioncount_easy);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
			
				tempList = randomQuestionList( questionMediumlist ,totalonemarkquestioncount_medium);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				tempList = randomQuestionList( questionHardlist ,totalonemarkquestioncount_hard);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				//Two mark
				questionEasylist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(), questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_two_mark_id());
				questionMediumlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_medium_id(), examquestionproperty.getProperty_two_mark_id());
				questionHardlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),	questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_hard_id(), examquestionproperty.getProperty_two_mark_id());
								 
				
				tempList = randomQuestionList( questionEasylist ,totaltwomarkquestioncount_easy);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
			
				tempList = randomQuestionList( questionMediumlist ,totaltwomarkquestioncount_medium);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				tempList = randomQuestionList( questionHardlist ,totaltwomarkquestioncount_hard);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				
				//Five mark
				questionEasylist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(), questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_five_mark_id());
				questionMediumlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_medium_id(), examquestionproperty.getProperty_five_mark_id());
				questionHardlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),	questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_hard_id(), examquestionproperty.getProperty_five_mark_id());
								 
				
				tempList = randomQuestionList( questionEasylist ,totalfivemarkquestioncount_easy);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
			
				tempList = randomQuestionList( questionMediumlist ,totalfivemarkquestioncount_medium);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				tempList = randomQuestionList( questionHardlist ,totalfivemarkquestioncount_hard);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
		
				//Ten mark
				questionEasylist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(), questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_easy_id(), examquestionproperty.getProperty_five_mark_id());
				questionMediumlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_medium_id(), examquestionproperty.getProperty_five_mark_id());
				questionHardlist = questionrepository.getQuestionListbyExam(questionpaperaddordeletebean.getDepartmentID(),	questionpaperaddordeletebean.getSubjectID(),questionpaperaddordeletebean.getUnitIDList(),examquestionproperty.getProperty_hard_id(), examquestionproperty.getProperty_five_mark_id());
								 
				
				tempList = randomQuestionList( questionEasylist ,totaltenmarkquestioncount_easy);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
			
				tempList = randomQuestionList( questionMediumlist ,totaltenmarkquestioncount_medium);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				tempList = randomQuestionList( questionHardlist ,totaltenmarkquestioncount_hard);
				finalQuestionIDList= mergerandomQuestionList(tempList, finalQuestionIDList);
				
				for (Integer questionEntity : finalQuestionIDList) 
				{
				    System.out.println("****************************");
					System.out.println(" Exam Question  Id "+questionEntity.intValue());
				}
				
 				
			}
		 		
		}
		else if (required_exam_mark == Integer.valueOf(examquestionproperty.getProperty_exam_is_fifty_mark()) ) {
			System.out.println(" This is a 50 mark");
		}
		else if (required_exam_mark == Integer.valueOf(examquestionproperty.getProperty_exam_is_hundred_mark()) ) {
			System.out.println(" This is a 100 mark");
		}	
		
		 
		 
		
//		try(Connection connection = getJDBConnection();
//				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
//			 
//			callablestatement.setInt(1, questionpaperaddordeletebean.getNewQuestionpaperID()); 
//			callablestatement.setString(2, questionpaperaddordeletebean.getExamName());
//			callablestatement.setInt(3, questionpaperaddordeletebean.getDepartmentID()); 
//			callablestatement.setInt(4, questionpaperaddordeletebean.getTotalexammark()); 
//			callablestatement.setString(5, questionpaperaddordeletebean.getIssuppotoptional());
//			callablestatement.setObject(6,null);
//			callablestatement.registerOutParameter(6, java.sql.Types.INTEGER);
//			callablestatement.registerOutParameter(7, java.sql.Types.INTEGER);
//			callablestatement.registerOutParameter(8, java.sql.Types.VARCHAR);
//			
//			//callablestatement.executeUpdate();
//			outputbean.setPo_new_id(callablestatement.getInt(6));
//			outputbean.setPo_success_flag(callablestatement.getInt(7));
//			outputbean.setPo_message(callablestatement.getString(8));
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Exception Occured");
//		}
//		
		return outputbean;
	
	}
	
}
