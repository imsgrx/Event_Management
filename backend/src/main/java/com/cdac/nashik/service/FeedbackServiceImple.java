package com.cdac.nashik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.nashik.entity.Feedback;
import com.cdac.nashik.repository.FeedbackRepo;

@Service
public class FeedbackServiceImple implements FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepo;     //proxy
	
	@Override
	public Feedback insertFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackRepo.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return this.feedbackRepo.findAll();
	}

}
