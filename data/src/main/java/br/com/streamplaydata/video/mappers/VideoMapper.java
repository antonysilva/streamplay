package br.com.streamplaydata.video.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.streamplaydata.article.model.ArticleIterator;
import br.com.streamplaydata.video.model.VideoIterator;
import br.com.streamplaydata.video.model.VideoModel;
import br.com.streamplaydomain.article.Article;
import br.com.streamplaydomain.video.Video;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class VideoMapper implements VideoMapperContract{


    @Override
    public List<Video> convertListFromDataToDomain(VideoModel[] videoModels) {
        List<Video> videoList = new ArrayList<>();
        Iterator videoIterator = new VideoIterator(videoModels);

        while(videoIterator.hasNext()){
            Video video = (Video) videoIterator.next();

            int id = video.getId();
            String title = video.getTitle();
            String description = video.getDescription();
            String category = video.getCategory();
            String image_url = video.getImage_url();
            String video_url = video.getVideo_url();
            List<String> tags = video.getTags();

            videoList.add(new Video(id, title, description, category, image_url, video_url, tags));
        }

        return videoList;
    }

}
