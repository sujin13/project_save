package example.domain.feedPost.mapper;

import example.domain.fans.entity.Fans;
import example.domain.feedPost.dto.feedPostDto;
import example.domain.feedPost.dto.feedPostResponseDto;
import example.domain.feedPost.entity.FeedPost;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface feedPostMapper {
    // feedPostDto.Post -> feedPost
    default FeedPost feedPostDtoToFeed(feedPostDto.Post requestBody, Fans fans){
        FeedPost feedPost = new FeedPost(requestBody.getContent(), requestBody.getImg(), fans);
        return feedPost;
    }

    // feedPost -> feedPostDto.Response
    feedPostResponseDto feedToFeedResponseDto(FeedPost feedPost);
    List<feedPostResponseDto> feedPostsToFeedResponseDtos(List<FeedPost> feedPosts);

    // feedPostDto.Patch -> feedPost
    default FeedPost feedPatchDtoToFeed(feedPostDto.Patch requestBody, Fans fans){
        FeedPost feedPost = new FeedPost(requestBody.getContent(), requestBody.getImg(), fans);
        feedPost.setId(requestBody.getFeedPostId());
        return feedPost;
    }
}
