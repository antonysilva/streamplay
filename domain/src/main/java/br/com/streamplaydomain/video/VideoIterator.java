package br.com.streamplaydomain.video;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class VideoIterator implements Iterator<Video> {

    Video[] videos;
    int position = 0;

    public VideoIterator(Video[] videos){
        this.videos = videos;
    }

    @Override
    public boolean hasNext() {
        if(position >= videos.length || videos[position] == null){
            return false;
        }else { return true; }
    }

    @Override
    public Video next() {
        Video video = videos[position];
        position++;
        return video;
    }

}
