package wccifall2020.reviews.repositories;

import org.springframework.data.repository.CrudRepository;
import wccifall2020.reviews.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
