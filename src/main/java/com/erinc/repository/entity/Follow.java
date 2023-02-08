package com.erinc.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Benim Takip Ettiğim kişileri bulmak için --> select * from tblfollow where userid=?
 * Beni takip eden kişileri bulmak için  --> select * from tblfollow followingid=?
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblfollow")
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long followerid; // Takip eden kişi id'si...
    Long followingid;  // Takip edilen kişinin id'si...
}
