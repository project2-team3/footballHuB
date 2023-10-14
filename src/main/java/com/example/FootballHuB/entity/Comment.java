package com.example.FootballHuB.entity;

import com.example.FootballHuB.dto.CommentDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="comments")
@Getter @Setter
@ToString
public class Comment extends BaseEntity {
    @Id @GeneratedValue
    @Column(name="comment_id")
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateComment(CommentDto commentDto) {
        this.content = commentDto.getContent();
    }
}
