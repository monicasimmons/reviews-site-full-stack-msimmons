package wccifall2020.reviews.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
public class Review {

    //allow for description/content/body longer than 255 characters

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String title;
    private String imageURL;       
    private String content;
    @ManyToOne
    private Category category;

    public Review() {
    }

    public Review(String date, String title, String imageURL, String content, Category category) {
        this.date = date;
        this.title = title;
        this.imageURL = imageURL;
        this.content = content;
        this.category = category;
    }

    public Long getId(){
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getContent() {
        return content;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
