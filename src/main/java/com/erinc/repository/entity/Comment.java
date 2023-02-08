package com.erinc.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblcomment")
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tweetid;
    /**
     * Tweet için yapılan yorum id.
     */
    Long commentid;
    /**
     * Tweet'e yada Yorum yapan başka bir kişiye yorum yapan kişi
     */
    Long userid;
    @Column(length = 280)
    String comment;
    Long commentdate;

}
