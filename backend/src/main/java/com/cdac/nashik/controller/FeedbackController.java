package com.cdac.nashik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.nashik.entity.Feedback;
import com.cdac.nashik.service.FeedbackService;

@CrossOrigin
@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/getallfeedbacks")
	public List<Feedback> getAllFeedbacks(Feedback feedback){	
		return feedbackService.getAllFeedbacks();	
	}
	
	@PostMapping("/savefeedback")
	public Feedback insertFeedback(@RequestBody Feedback feedback) {
		return feedbackService.insertFeedback(feedback);
	}
}
