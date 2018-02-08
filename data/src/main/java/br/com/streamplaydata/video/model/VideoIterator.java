package br.com.streamplaydata.video.model;

import java.util.Iterator;

import br.com.streamplaydata.article.model.ArticleModel;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class VideoIterator implements Iterator<VideoModel> {

    VideoModel[] videoModels;
    int position = 0;

    public VideoIterator(VideoModel[] articleModels){
        this.videoModels = articleModels;
    }

    @Override
    public boolean hasNext() {
        if(position >= this.videoModels.length || this.videoModels[position] == null){
            return false;
        }else { return true; }
    }

    @Override
    public VideoModel next() {
        VideoModel videoModel = this.videoModels[position];
        position++;
        return videoModel;
    }

}
