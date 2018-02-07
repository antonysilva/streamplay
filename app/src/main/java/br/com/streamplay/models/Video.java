package br.com.streamplay.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Antony on 09/12/2017.
 */

public class Video implements Serializable{

    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("category")
    String category;
    @SerializedName("image_url")
    String image_url;
    @SerializedName("video_url")
    String video_url;
    @SerializedName("tags")
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
