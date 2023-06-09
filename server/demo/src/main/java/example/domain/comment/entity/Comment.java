package example.domain.comment.entity;

import example.domain.artistPost.entity.ArtistPost;
import example.domain.fans.entity.Fans;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import example.domain.feedPost.entity.FeedPost;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 16000, nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedPost_id")
    private FeedPost feedPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistPost_id")
    private ArtistPost artistPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fan_id")
    private Fans fans;

    public Comment(FeedPost feedPost, String content, Fans fans) {
        this.feedPost = feedPost;
        this.content = content;
        this.fans = fans;
    }
}
