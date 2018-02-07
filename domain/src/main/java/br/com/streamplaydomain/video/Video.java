package br.com.streamplaydomain.video;

import java.util.List;

public class Video {

    int id;
    String title;
    String description;
    String category;
    String image_url;
    String video_url;
    List<String> tags;

    public Video(){}

    public Video(int id, String title, String description, String category, String image_url, String video_url, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.image_url = image_url;
        this.video_url = video_url;
        this.tags = tags;
    }

}
