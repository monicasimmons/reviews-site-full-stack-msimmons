package wccifall2020.reviews.repositories;

import org.springframework.data.repository.CrudRepository;
import wccifall2020.reviews.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByCategoryName(String categoryName);
}
