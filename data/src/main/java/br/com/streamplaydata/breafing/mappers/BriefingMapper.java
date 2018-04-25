package br.com.streamplaydata.breafing.mappers;

import br.com.streamplaydata.article.mapper.ArticleMapper;
import br.com.streamplaydata.breafing.model.BriefingModel;
import br.com.streamplaydata.models.mappers.VideoModelMapper;
import br.com.streamplaydomain.entities.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class BriefingMapper {

    ArticleMapper articleMapper;
    VideoModelMapper videoMapper;

    public BriefingMapper(){
        articleMapper = new ArticleMapper();
        videoMapper = new VideoModelMapper();
    }


    public Briefing fromDataToDomain(BriefingModel briefingModel){
        Briefing briefingDomain = new Briefing();
        briefingDomain.setArticles(articleMapper.convertListFromDataToDomain(briefingModel.getArticleModels()));
//        briefingDomain.setVideos(videoMapper.convertListFromDataToDomain(briefingModel.getVideoModels()));

        return briefingDomain;
    }

}
