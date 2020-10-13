package wccifall2020.reviews;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import wccifall2020.reviews.models.Category;
import wccifall2020.reviews.models.Review;
import wccifall2020.reviews.repositories.CategoryRepository;
import wccifall2020.reviews.repositories.ReviewRepository;


import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private CategoryRepository categoryRepo;

    @MockBean
    private ReviewRepository reviewRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void categoriesShouldBeOkAndReturnCategoriesViewWithCategoriesModelAttribute() throws Exception {
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("categories"));
    }

    @Test
    public void reviewsShouldBeOkAndReturnReviewsViewWithReviewsModelAttribute() throws Exception {
        mockMvc.perform(get("/reviews"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reviewsView"))
                .andExpect(model().attributeExists("reviews"));
    }

    @Test
    public void shouldBeOkForASingleCategoryEndpointWithCategoryViewAndCategoryModelAttribute() throws Exception {
        Category testCategory = new Category("toy");
        when(categoryRepo.findCategoryByCategoryName("toy")).thenReturn(testCategory);
        mockMvc.perform(get("/categories/toy"))
                .andExpect(status().isOk())
                .andExpect(view().name("categoryView"))
                .andExpect(model().attributeExists("category"));
    }

    @Test
    public void shouldBeOkForASingleReviewEndpointWithReviewViewAndReviewModelAttribute() throws Exception {
        Category testCategory = new Category("toy");
        Review testReview = new Review("Date", "Title", "Image URL", "Content", testCategory);
        when(reviewRepo.findById(1L)).thenReturn(Optional.of(testReview));
        mockMvc.perform(get("/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("reviewView"))
                .andExpect(model().attributeExists("review"));
    }
}
