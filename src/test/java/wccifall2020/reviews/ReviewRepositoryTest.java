package wccifall2020.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

public class ReviewRepositoryTest {

    private ReviewRepository underTest;
    private Review reviewOne = new Review(1L, "date", "category", "title", "image", "review content");
    private Review reviewTwo = new Review(2L, "date", "category", "title", "image", "review content");

    @Test
    public void shouldFindReviewOne(){
        underTest = new ReviewRepository(reviewOne);
        Review foundReview = underTest.findOne(1L);
        assertEquals(reviewOne, foundReview);
    }

    @Test
    public void shouldFindReviewOneAndReviewTwo(){
        underTest = new ReviewRepository(reviewOne, reviewTwo);
        Collection<Review> foundReviews = underTest.findAll();
        assertThat(foundReviews).contains(reviewOne, reviewTwo);
    }

}
