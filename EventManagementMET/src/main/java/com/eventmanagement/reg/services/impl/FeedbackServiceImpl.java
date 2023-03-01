package com.eventmanagement.reg.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.reg.entities.Customer;
import com.eventmanagement.reg.entities.Feedback;
import com.eventmanagement.reg.exceptions.ResourceNotFoundException;
import com.eventmanagement.reg.payloads.FeedbackDto;
import com.eventmanagement.reg.repositories.CustomerRepo;
import com.eventmanagement.reg.repositories.FeedbackRepo;
import com.eventmanagement.reg.services.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	//create
	@Override
	public FeedbackDto createFeedback(FeedbackDto feedbackDto, Integer customerId) {
		Customer customer = this.customerRepo.findById(customerId)
				.orElseThrow(()->new ResourceNotFoundException("Customer","Customer id",customerId));
		
		Feedback feedback = this.modelMapper.map(feedbackDto, Feedback.class);
		feedback.setCustomer(customer);
		Feedback newFeedback = this.feedbackRepo.save(feedback);
		
		return this.modelMapper.map(newFeedback, FeedbackDto.class);
	}

	//delete
	@Override
	public void deleteFeedback(Integer feedbackId) {
		Feedback feedback = this.feedbackRepo.findById(feedbackId)
				.orElseThrow(()->new ResourceNotFoundException("Feedback","feedback id",feedbackId));
		
		this.feedbackRepo.delete(feedback);
	}

	//get all feedback
	@Override
	public List<FeedbackDto> getAllFeedback() {
		List<Feedback> allFeedbacks = this.feedbackRepo.findAll();
		
		List<FeedbackDto> feedbackDtos = allFeedbacks.stream().map((feedback)->this.modelMapper.map(feedback, FeedbackDto.class)).collect(Collectors.toList());
		
		return feedbackDtos;
	}

	//get feedback by customer ID
	@Override
	public List<FeedbackDto> getFeedbackByCustomer(Integer customerId) {
		Customer customer = this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customerId",customerId));
		List<Feedback> feedbacks = this.feedbackRepo.findByCustomer(customer);
		
		List<FeedbackDto> feedbackDtos = feedbacks.stream().map((feedback)->this.modelMapper.map(feedback, FeedbackDto.class)).collect(Collectors.toList());
		return feedbackDtos;
	}

	
	
	
	public Feedback dtotoFeedback(FeedbackDto feedbackDto) {
		Feedback feedback = this.modelMapper.map(feedbackDto, Feedback.class);
		return feedback;
	}
	
	
	public FeedbackDto feedbackToDto(Feedback feedback) {
		FeedbackDto feedbackDto = this.modelMapper.map(feedback, FeedbackDto.class);
		return feedbackDto;
	}
}
