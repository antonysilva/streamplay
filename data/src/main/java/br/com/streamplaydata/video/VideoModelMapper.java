package br.com.streamplaydata.video;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydomain.video.VideoEntity;

public class VideoModelMapper {

    private static VideoModelMapper instance;

    public static VideoModelMapper getInstance() {
        if(instance == null)
            instance = new VideoModelMapper();
        return instance;
    }

    public VideoEntity convert(VideoModel videoModel){
        return null;
    }

    public List<VideoEntity> convert(List<VideoModel> videoModel){
        List<VideoEntity> videos = new ArrayList<>();
        try{
            VideoIterator videoIterator = new VideoIterator(videoModel);
            while (videoIterator.hasNext()){
                VideoModel vMode1 = videoIterator.next();

                Integer      id = vMode1.getId();
                String       title = vMode1.getTitle();
                String       description = vMode1.getDescription();
                String       category = vMode1.getCategory();
                List<String> tags = vMode1.getTags();
                String       image_url = vMode1.getImage_url();
                String       video_url = vMode1.getVideo_url();

                videos.add(new VideoEntity(id, title, description, category, tags, image_url, video_url));
            }
        }catch (Exception ex){
        }

        return videos;
    }
}
