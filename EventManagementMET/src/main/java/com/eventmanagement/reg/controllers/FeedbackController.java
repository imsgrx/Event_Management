package com.eventmanagement.reg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.reg.payloads.ApiResponse;
import com.eventmanagement.reg.payloads.FeedbackDto;
import com.eventmanagement.reg.services.BookingService;
import com.eventmanagement.reg.services.FeedbackService;

@RestController
@RequestMapping("/api/")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	//create
	
	@PostMapping("/customer/{customerId}/feedback")
	public ResponseEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto, @PathVariable Integer customerId)
	{
		FeedbackDto createFeedback = this.feedbackService.createFeedback(feedbackDto, customerId);
		return new ResponseEntity<FeedbackDto>(createFeedback,HttpStatus.CREATED);
	}
	
	
	//delete
	
	@DeleteMapping("/feedback/{feedbackId}")
	public ApiResponse deleteFeedback(@PathVariable Integer feedbackId)
	{
		this.feedbackService.deleteFeedback(feedbackId);
		return new ApiResponse("Feedback is Sucessfully deleted", true);
	}
	
	//Get all feedback
	
	@GetMapping("/feedback")
	public ResponseEntity<List<FeedbackDto>> getAllFeedback(){
		List<FeedbackDto> allFeedback = this.feedbackService.getAllFeedback();
		return new ResponseEntity<List<FeedbackDto>>(allFeedback,HttpStatus.OK);
	}
	
	//feedback by customer
	@GetMapping("/customer/{customerId}/feedback")
	public ResponseEntity<List<FeedbackDto>> getFeedbacksByCustomer(@PathVariable Integer customerId){
		List<FeedbackDto> feedbacks = this.feedbackService.getFeedbackByCustomer(customerId);
		return new ResponseEntity<List<FeedbackDto>>(feedbacks,HttpStatus.OK);
	}
}




