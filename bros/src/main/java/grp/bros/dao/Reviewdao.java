package grp.bros.dao;

import java.util.List;

import grp.bros.model.Review;

public interface Reviewdao {

public void addReview(Review review);

public List<Review> getPageReviews();

	
}
