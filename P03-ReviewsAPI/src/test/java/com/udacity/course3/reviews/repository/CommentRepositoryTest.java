package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import java.util.List;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
  @Autowired
  private DataSource _dataSource;
  @Autowired
  private JdbcTemplate _jdbcTemplate;
  @Autowired
  private TestEntityManager _entityManager;
  @Autowired
  private CommentRepository _commentRepository;

  @Test
  public void injectedComponentAreNotNull() {
    assertThat(_dataSource).isNotNull();
    assertThat(_jdbcTemplate).isNotNull();
    assertThat(_entityManager).isNotNull();
    assertThat(_commentRepository).isNotNull();
  }

  @Test
  public void findAllByReview() {

    Review review = new Review();
    review.setTitle("great");
    review.setContent("very good one");
    _entityManager.persist(review);

    Comment comment1 = new Comment();
    comment1.setTitle("comment1");
    comment1.setContent("very good");
    comment1.setReview(review);
    _entityManager.persist(comment1);

    Comment comment2 = new Comment();
    comment2.setTitle("comment2");
    comment2.setContent("very good");
    comment2.setReview(review);
    _entityManager.persist(comment2);

    List<Comment> allComments = _commentRepository.findAllByReview(review);
    assertEquals(allComments.size(), 2);
    assertEquals(allComments.get(0).getTitle(), "comment1");
    assertEquals(allComments.get(0).getContent(), "very good");
  }
}