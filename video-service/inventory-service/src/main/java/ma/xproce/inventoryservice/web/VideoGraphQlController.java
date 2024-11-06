package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.service.CreatorServiceManager;
import ma.xproce.inventoryservice.service.VideoServiceManager;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorServiceManager creatorServiceManager;
    private VideoServiceManager videoServiceManager;

    VideoGraphQlController(CreatorServiceManager creatorServiceManager, VideoServiceManager videoServiceManager){
        this.creatorServiceManager = creatorServiceManager;
        this.videoServiceManager = videoServiceManager;
    }

    @QueryMapping
    public List<Video> videoList(){
        return videoServiceManager.videoList();
    }

    @QueryMapping
    public Creator creatorById(@Argument Integer id){
        return creatorServiceManager.creatorById(id);
    }

}