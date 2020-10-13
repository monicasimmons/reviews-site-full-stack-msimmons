package wccifall2020.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import wccifall2020.reviews.models.Category;
import wccifall2020.reviews.models.Review;
import wccifall2020.reviews.repositories.CategoryRepository;
import wccifall2020.reviews.repositories.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ReviewRepository reviewRepo;

    @Test
    public void categoryShouldHaveAListOfReviews() {
        Category testCategory = new Category("Test category name");
        Category testCategory2 = new Category("Test category name2");
        Review testReview = new Review("Date", "Title", "Image URL", "Content", testCategory);
        Review testReview2 = new Review("Date", "Title", "Image URL", "Content", testCategory2);

        categoryRepo.save(testCategory);
        categoryRepo.save(testCategory2);
        reviewRepo.save(testReview);
        reviewRepo.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        assertThat(retrievedCategory.getReviews()).contains(testReview);
    }
}
