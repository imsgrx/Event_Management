package com.eventmanagement.reg.services;

import java.util.List;

import com.eventmanagement.reg.payloads.FeedbackDto;

public interface FeedbackService {
	//create	
	FeedbackDto createFeedback(FeedbackDto feedbackDto, Integer customerId);
	
	//delete	
	void deleteFeedback(Integer feedbackId);
	
	//get all feedback
		List<FeedbackDto> getAllFeedback();
	
	//get all feedback customerId
		List<FeedbackDto> getFeedbackByCustomer(Integer customerId);
}
