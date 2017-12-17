package br.com.streamplay.models;

import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Antony on 09/12/2017.
 */

public class Video implements Serializable{

    private int id;
    private String title;
    private String description;
    private String category;
    private String image_url;
    private String video_url;
    private List<String> tags;

    public Video(){}

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

    public String getShortDescription() {
        if (description.length() > 100)
            return description.substring(0,99) + "...";
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

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getVideoUrl() {
        return video_url;
    }

    public void setVideoUrl(String videoUrl) {
        this.video_url = videoUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
