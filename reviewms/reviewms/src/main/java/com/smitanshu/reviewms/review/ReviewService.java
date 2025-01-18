package com.smitanshu.reviewms.review;


import java.util.List;


public interface ReviewService {


    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReviewById(Long reviewId);

    boolean deleteReviewById(Long reviewId);

    boolean updateReview(Long reviewId, Review review);
}
