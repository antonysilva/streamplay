package br.com.streamplaydomain.Video;

import java.io.Serializable;
import java.util.List;

public class VideoEntity implements Serializable {

    public int          id;
    public String       title;
    public String       description;
    public String       category;
    public List<String> tags;
    public String       image_url;
    public String       video_url;

    public VideoEntity() {
    }

    public VideoEntity(Integer id, String title, String description, String category, List<String> tags, String image_url, String video_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.image_url = image_url;
        this.video_url = video_url;
    }

}
