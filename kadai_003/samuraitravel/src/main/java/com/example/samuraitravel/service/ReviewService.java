package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.form.ReviewEditForm;
import com.example.samuraitravel.form.ReviewForm;
import com.example.samuraitravel.repository.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Transactional
	public void create(House house, User user, ReviewForm reviewForm) {
		Review review = new Review();
		
		review.setHouse(house);
		review.setUser(user);
		review.setScore(reviewForm.getScore());
		review.setContent(reviewForm.getContent());
		
		reviewRepository.save(review);
	}
	
	@Transactional
	public void update(ReviewEditForm reviewEditForm) {
		Review review = reviewRepository.getReferenceById(reviewEditForm.getId());
		
		review.setScore(reviewEditForm.getScore());
		review.setContent(reviewEditForm.getContent());
		
		reviewRepository.save(review);
	}
	
	public boolean userAlreadyReviewed(House house, User user) {
		return reviewRepository.findByHouseAndUser(house, user) != null;
	}
}
