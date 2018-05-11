package br.com.streamplay.home.video;

import android.content.Context;

import br.com.streamplay.UIThread;
import br.com.streamplaydata.video.api.GetAllVideosRepositoryImpl;
import br.com.streamplaydomain.Base.ThreadExecutor;
import br.com.streamplaydomain.Video.GetAllVideos.GetAllVideosInteractor;

public class VideoHomeBuilder {
    public static GetAllVideosInteractor create(Context context){
        return new GetAllVideosInteractor(ThreadExecutor.getInstance(), UIThread.getInstance(),
                new GetAllVideosRepositoryImpl());
    }
}
