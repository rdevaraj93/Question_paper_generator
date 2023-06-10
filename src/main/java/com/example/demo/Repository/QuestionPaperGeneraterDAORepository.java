package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.example.demo.QuestionPatten.ExamPatten;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;


@Repository
public class QuestionPaperGeneraterDAORepository  extends DataBaseAdapter{

	
	@Autowired
	ExamPatten exampatten;
	
	@Autowired
	Environment env;
	
	public ProcedureOutputResponceBean generateNewQuestionPaper(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		//String pkguseraddorupdate =  "{call pkg_create_update_ques_paper(?,?,?,?,?,?,?,?,?)}";
		
		var exam_is_ten_mark = env.getProperty("exam_is_ten_mark");
		var exam_is_twenty_mark = env.getProperty("exam_is_twenty_mark");
		var exam_is_fifty_mark = env.getProperty("exam_is_fifty_mark");
		var exam_is_hundred_mark = env.getProperty("exam_is_hundred_mark");
		System.out.println(exam_is_ten_mark + " " + exam_is_twenty_mark + " " + exam_is_fifty_mark + " " + exam_is_hundred_mark);
		
		var required_exam_mark = questionpaperaddordeletebean.getTotalexammark();
		//System.out.println(" This is a ten mark " + required_exam_mark);
		
		if (required_exam_mark == Integer.valueOf(exam_is_ten_mark) ) {
			System.out.println(" This is a ten mark");
		}
		else if (required_exam_mark == Integer.valueOf(exam_is_twenty_mark) ) {
			System.out.println(" This is a 20 mark");
		}
		else if (required_exam_mark == Integer.valueOf(exam_is_fifty_mark) ) {
			System.out.println(" This is a 50 mark");
		}
		else if (required_exam_mark == Integer.valueOf(exam_is_hundred_mark) ) {
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
