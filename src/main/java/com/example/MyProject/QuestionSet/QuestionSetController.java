package com.example.MyProject.QuestionSet;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class QuestionSetController {
	
	@Autowired
	QuestionSetService questionSetService;
	
	
	@RequestMapping("/questionsets")
	public List<QuestionSet> getAllQuestionSets(){
		return questionSetService.getAllQuestionSets();
	}
	
	@RequestMapping("/questionsets/{question}")
	public QuestionSet getQuestionSetByQuestion(@PathVariable String question) {
		return questionSetService.getQuestionSetByQuestion(question);
	}
	
	@PostMapping("/questionsets")
	public void postController(
	  @RequestBody QuestionSet questionSet) {
		
		questionSetService.addQuestionSet(questionSet);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/questionsets")
	public void deleteAllQuestionSets() {
		questionSetService.removeAllQuestionSets();
		
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/questionsets/{question}")
	public void deleteQuestionSetById(@PathVariable String question) {
		questionSetService.removeQuestionSetById(question);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/questionsets/{question}")
	public void updateQuestionSet(@RequestBody QuestionSet questionSet,@PathVariable String question) {
		questionSetService.updateQuestionSet(questionSet, question);
	}

}
