package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.DepartmentAddOrUpdateBean;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionAddOrUpdateBean;

@Repository
public class QuestionDAORepository extends DataBaseAdapter {

	public ProcedureOutputResponceBean questionAddOrUpdate(QuestionAddOrUpdateBean questionaddorupdatebean) {
		
		ProcedureOutputResponceBean outputbean = new ProcedureOutputResponceBean();
		//System.out.println("User Add is working fine ------------------>");
		String pkguseraddorupdate =  "{call pkg_create_update_Question(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		try(Connection connection = getJDBConnection();
				CallableStatement callablestatement = getCallableStatement(connection, pkguseraddorupdate)){
			 
			callablestatement.setInt(1, questionaddorupdatebean.getQuestionId()); 
			callablestatement.setString(2, questionaddorupdatebean.getQuestionDescription());
			callablestatement.setInt(3, questionaddorupdatebean.getDepartId()); 
			callablestatement.setInt(4, questionaddorupdatebean.getSubjectId()); 
			callablestatement.setInt(5, questionaddorupdatebean.getUnitId()); 
			callablestatement.setInt(6, questionaddorupdatebean.getDifficultyId()); 
			callablestatement.setInt(7, questionaddorupdatebean.getTermId()); 
			callablestatement.setInt(8, questionaddorupdatebean.getQuestWeightAgeId());
			callablestatement.setString(9, questionaddorupdatebean.getIsImportant());
			callablestatement.setString(10, questionaddorupdatebean.getIsRepeat());
			callablestatement.setString(11, questionaddorupdatebean.getIsValid());		 
			callablestatement.setInt(12, questionaddorupdatebean.getCreateUserId()); 
			callablestatement.setInt(13, questionaddorupdatebean.getUpdatedUserId()); 
			callablestatement.registerOutParameter(14, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(15, java.sql.Types.INTEGER);
			callablestatement.registerOutParameter(16, java.sql.Types.VARCHAR);	
			callablestatement.executeUpdate();
			outputbean.setPo_new_id(callablestatement.getInt(14));
			outputbean.setPo_success_flag(callablestatement.getInt(15));
			outputbean.setPo_message(callablestatement.getString(16));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
		
		return outputbean;
	
	}
	
}
