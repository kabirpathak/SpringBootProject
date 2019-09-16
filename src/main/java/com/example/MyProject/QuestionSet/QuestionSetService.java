package com.example.MyProject.QuestionSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionSetService {

	@Autowired
	QuestionSetRepository qsetR;
	
	
		
		
	
	public List<QuestionSet> getAllQuestionSets() {
		//return questionSets;
	List<QuestionSet> temp = new ArrayList<>();
	 qsetR.findAll().forEach(temp::add);
	 return temp;
	}
	
	public QuestionSet getQuestionSetByQuestion(String question) {
		//return questionSets.stream().filter(t -> t.getQuestion().equals(question)).findFirst().get();
		return qsetR.findById(question).orElse(null);
	}
	
	
	public ResponseEntity addQuestionSet( QuestionSet questionSet) {
		qsetR.save(questionSet);
	    return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
	public void removeQuestionSetById(String question) {
		qsetR.deleteById(question);
	}
	
	
	public void removeAllQuestionSets() {
		qsetR.deleteAll();
	}
	
	
	public void updateQuestionSet(QuestionSet questionSet, String question) {
		qsetR.save(questionSet);
	}

	

}
