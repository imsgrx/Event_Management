package com.cdac.nashik.service;

import java.util.List;

import com.cdac.nashik.entity.Feedback;
import com.cdac.nashik.entity.User;


public interface FeedbackService {

	
	public Feedback insertFeedback(Feedback feedback);
	public List<Feedback> getAllFeedbacks();
	
}
