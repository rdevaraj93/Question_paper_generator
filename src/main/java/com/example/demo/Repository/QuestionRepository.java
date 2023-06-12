package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.QuestionListViewEntiry;

@Repository
public interface QuestionRepository extends  CrudRepository<QuestionListViewEntiry, Integer>{

	@Query("SELECT questionlist FROM QuestionListViewEntiry questionlist order by questionid asc")
	List<QuestionListViewEntiry> getAllQuestionlist();
	
	@Query("SELECT questionlist FROM QuestionListViewEntiry questionlist where questionid in (:questionid) order by questionid asc")
	List<QuestionListViewEntiry> getQuestionById(Integer questionid);
	
	@Query("SELECT questionlist FROM QuestionListViewEntiry questionlist where departmentID in (:departmentid) AND subjectid in (:subjectid) "
			+ "AND unitid in (:unitid) and difficultyid in (:difficultyid)"	+ " AND questionweightid in (:questionweightid )"
			+" AND isvalid = 'Y'order by questionid asc")
	List<QuestionListViewEntiry> getQuestionListbyExam(Integer departmentid, Integer subjectid,  List<Integer> unitid, Integer difficultyid, Integer questionweightid);
	 
}
