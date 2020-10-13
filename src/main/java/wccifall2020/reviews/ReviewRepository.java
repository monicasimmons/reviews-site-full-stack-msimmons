package wccifall2020.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {

    Map<Long, Review> reviewsList = new HashMap<>();

    public ReviewRepository(){
        Review buzzLightyear = new Review(1L, "June 24, 2019", "Toy", "My daughter loves this!", "/images/buzzlightyear.jpg", "This Buzz Lightyear toy is perfect for a 5 year old. Well made and durable. Plays several of Buzz's famous sayings, too.");
        Review woody = new Review(2L, "April 15, 2020", "Toy", "My favorite cowboy", "/images/woody.jpg", "Woody is just as described. Floppy and fun. Woody, you've got a friend in me!");
        Review cinqueTerre = new Review(3L, "August 12, 2019", "Travel", "It's amore", "/images/cinqueterre.jpg", "Cinque Terre won't disappoint. The picturesque walking trail is a must-do. Stop at a local restaurant for fresh, delicious seafood.");
        Review barbados = new Review(4L, "May 7, 2019", "Travel", "What's not to love?", "/images/barbados.jpg", "Barbados is a great vacation spot. Take a Segway tour, go zip lining, or snorkel. There's something for everyone!");
        Review atHeadphones = new Review(5L, "March 29, 2020", "Tech", "Perfect for working at home", "/images/headphones.jpg", "I needed good headphones with a microphone now that we're working remotely, and these did not disappoint. Clear sound, easy to use, haven't had any compatibility issues with my Dell computer.");
        Review alexa = new Review (6L, "September 3, 2020", "Tech", "You'll wonder how you ever lived without her", "/images/echo.jpg", "Alexa is the answer to the question you didn't know you had. Make your grocery list, play your favorite tunes, and even turn your lights on and off with simple voice commands!");

        reviewsList.put(buzzLightyear.getId(), buzzLightyear);
        reviewsList.put(woody.getId(), woody);
        reviewsList.put(cinqueTerre.getId(), cinqueTerre);
        reviewsList.put(barbados.getId(), barbados);
        reviewsList.put(atHeadphones.getId(), atHeadphones);
        reviewsList.put(alexa.getId(), alexa);

    }

    public ReviewRepository(Review... reviewsToAdd){
        for (Review review : reviewsToAdd) {
            reviewsList.put(review.getId(), review);
        }
    }

    public Review findOne(long id){
        return reviewsList.get(id);
    }

    public Collection<Review> findAll(){
        return reviewsList.values();
    }
}
