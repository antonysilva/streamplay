package br.com.streamplaydata.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoModel {

    @SerializedName("id")
    private Integer  id;
    @SerializedName("title")
    private String   title;
    @SerializedName("description")
    private String   description;
    @SerializedName("category")
    private String   category;
    @SerializedName("tags")
    private List<String> tags;
    @SerializedName("avatar")
    private String   image_url;
    @SerializedName("url")
    private String   video_url;

    public VideoModel() {
    }

    public VideoModel(Integer id, String title, String description, String category, List<String> tags, String image_url, String video_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.image_url = image_url;
        this.video_url = video_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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
}
