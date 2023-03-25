package com.cdac.nashik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.nashik.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, String> {

}
