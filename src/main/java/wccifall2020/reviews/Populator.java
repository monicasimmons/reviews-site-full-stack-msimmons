package wccifall2020.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wccifall2020.reviews.models.Category;
import wccifall2020.reviews.models.Review;
import wccifall2020.reviews.repositories.CategoryRepository;
import wccifall2020.reviews.repositories.ReviewRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CategoryRepository categoryRepo;
    @Resource
    private ReviewRepository reviewRepo;

    @Override
    public void run(String... args) throws Exception {

        Category toy = new Category("Toy");
        Category travel = new Category("Travel");
        Category tech = new Category("Tech");
        categoryRepo.save(toy);
        categoryRepo.save(travel);
        categoryRepo.save(tech);

        Review buzzLightyear = new Review("June 24, 2019", "My daughter loves this!", "/images/buzzlightyear.jpg", "This Buzz Lightyear toy is perfect for a 5 year old. Well made and durable. Plays several of Buzz's famous sayings, too.", toy);
        Review woody = new Review("April 15, 2020", "My favorite cowboy", "/images/woody.jpg", "Woody is just as described. Floppy and fun. Woody, you've got a friend in me!", toy);
        Review cinqueTerre = new Review("August 12, 2019", "It's amore", "/images/cinqueterre.jpg", "Cinque Terre won't disappoint. The picturesque walking trail is a must-do. Stop at a local restaurant for fresh, delicious seafood.", travel);
        Review barbados = new Review("May 7, 2019", "What's not to love?", "/images/barbados.jpg", "Barbados is a great vacation spot. Take a Segway tour, go zip lining, or snorkel. There's something for everyone!", travel);
        Review atHeadphones = new Review("March 29, 2020", "Perfect for working at home", "/images/headphones.jpg", "I needed good headphones with a microphone now that we're working remotely, and these did not disappoint. Clear sound, easy to use, haven't had any compatibility issues with my Dell computer.", tech);
        Review alexa = new Review("September 3, 2020", "You'll wonder how you ever lived without her", "/images/echo.jpg", "Alexa is the answer to the question you didn't know you had. Make your grocery list, play your favorite tunes, and even turn your lights on and off with simple voice commands!", tech);
        reviewRepo.save(buzzLightyear);
        reviewRepo.save(woody);
        reviewRepo.save(cinqueTerre);
        reviewRepo.save(barbados);
        reviewRepo.save(atHeadphones);
        reviewRepo.save(alexa);
    }
}
