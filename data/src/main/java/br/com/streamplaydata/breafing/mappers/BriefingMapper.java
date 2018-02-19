package br.com.streamplaydata.breafing.mappers;

import br.com.streamplaydata.article.mapper.ArticleMapper;
import br.com.streamplaydata.breafing.model.BriefingModel;
import br.com.streamplaydata.video.mappers.VideoMapper;
import br.com.streamplaydomain.briefing.models.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class BriefingMapper {

    ArticleMapper articleMapper;
    VideoMapper videoMapper;

    public BriefingMapper(){
        articleMapper = new ArticleMapper();
        videoMapper = new VideoMapper();
    }


    public Briefing fromDataToDomain(BriefingModel briefingModel){
        Briefing briefingDomain = new Briefing();
        briefingDomain.setArticles(articleMapper.convertListFromDataToDomain(briefingModel.getArticleModels()));
        briefingDomain.setVideos(videoMapper.convertListFromDataToDomain(briefingModel.getVideoModels()));

        return briefingDomain;
    }

}
