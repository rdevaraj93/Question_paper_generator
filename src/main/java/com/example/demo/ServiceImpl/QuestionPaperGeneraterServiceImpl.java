package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.QuestionPaperGeneraterDAORepository;
import com.example.demo.Service.QuestionPaperGeneraterService;
import com.example.demo.dto.ProcedureOutputResponceBean;
import com.example.demo.dto.QuestionPaperAddOrDeleteBean;

@Service
public class QuestionPaperGeneraterServiceImpl implements QuestionPaperGeneraterService {

	@Autowired
	QuestionPaperGeneraterDAORepository  questionpapergeneraterdaorepository;
	
	@Override
	public ProcedureOutputResponceBean generateNewQuestionPaper(QuestionPaperAddOrDeleteBean questionpaperaddordeletebean) {
		System.out.println("TET");
		return questionpapergeneraterdaorepository.generateNewQuestionPaper(questionpaperaddordeletebean);
	}

}
