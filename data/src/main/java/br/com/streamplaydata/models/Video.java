package br.com.streamplaydata.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Video {

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

}
