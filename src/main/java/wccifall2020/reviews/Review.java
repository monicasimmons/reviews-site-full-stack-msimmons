package wccifall2020.reviews;


import java.awt.*;
import java.text.SimpleDateFormat;

public class Review {

    private Long id;
    private String date;
    private String category;
    private String title;
    private String imageURL;       
    private String content;


    public Review(Long id, String date, String category, String title, String imageURL, String content) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.title = title;
        this.imageURL = imageURL;
        this.content = content;
    }

    public Long getId(){
        return id;
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
}
