package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

  // TODO: Wire needed JPA repositories here
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private ReviewRepository reviewRepository;

  /**
   * Creates a comment for a review.
   *
   * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
   * 2. Check for existence of review.
   * 3. If review not found, return NOT_FOUND.
   * 4. If found, save comment.
   *
   * @param reviewId The id of the review.
   */
  @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
  public ResponseEntity<Comment> createCommentForReview(@PathVariable("reviewId") Integer reviewId,
      @RequestBody @NotNull Comment comment) {
    Optional<Review> optional = reviewRepository.findById(reviewId);
    if (optional.isPresent()) {
      comment.setReview(optional.get());
      return ResponseEntity.ok(commentRepository.save(comment));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  /**
   * List comments for a review.
   *
   * 2. Check for existence of review.
   * 3. If review not found, return NOT_FOUND.
   * 4. If found, return list of comments.
   *
   * @param reviewId The id of the review.
   */
  @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
  public List<Comment> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
    Review review = new Review();
    review.setId(reviewId);
    return commentRepository.findAllByReview(review);
  }
}
