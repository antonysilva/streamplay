package br.com.streamplaydata.video;

import java.util.Iterator;
import java.util.List;

import br.com.streamplaydata.video.VideoModel;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class VideoIterator implements Iterator<VideoModel> {

    private List<VideoModel> videoModels;
    private int position = 0;

    public VideoIterator(List<VideoModel> articleModels){
        this.videoModels = articleModels;
    }

    @Override
    public boolean hasNext() {
        if(position >= this.videoModels.size() || this.videoModels.get(position) == null){
            return false;
        }else { return true; }
    }

    @Override
    public VideoModel next() {
        VideoModel videoModel = this.videoModels.get(position);
        position++;
        return videoModel;
    }

}
