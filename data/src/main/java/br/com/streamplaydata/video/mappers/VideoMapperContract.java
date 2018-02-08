package br.com.streamplaydata.video.mappers;

import java.util.List;

import br.com.streamplaydata.article.model.ArticleModel;
import br.com.streamplaydata.video.model.VideoModel;
import br.com.streamplaydomain.article.Article;
import br.com.streamplaydomain.video.Video;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface VideoMapperContract {

    List<Video> convertListFromDataToDomain(VideoModel[] videoModels);

}
