package org.spring.social.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.spring.social.domain.posts.Post;

import java.util.List;

@Entity @Table
@Getter @ToString @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name = "user_id")
    private String id;
    private String name;
    private String email;
    private String message; // 상태메세지
    @Lob
    private byte[] profileImage;
    private int follow; // 팔로우 수
    private int following; // 팔로잉 수
    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Post> postId;

    @Builder
    public User(String id, String name, String email, String message, byte[] profileImage, int follow, int following, List<Post> postId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
        this.profileImage = profileImage;
        this.follow = follow;
        this.following = following;
        this.postId = postId;
    }
}
