package org.spring.social.domain.posts;

import jakarta.persistence.*;
import lombok.*;
import org.spring.social.domain.user.User;

@Entity @Table
@Getter @ToString @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int title;
    @Lob // String -> CLOB, byte[] -> BLOB 자동 설정
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Builder
    public Post(int id, int title, byte[] image, User userId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.userId = userId;
    }
}
