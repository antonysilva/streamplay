package br.com.streamplaydomain.video;

import java.io.Serializable;
import java.util.List;

public class Video implements Serializable{

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
