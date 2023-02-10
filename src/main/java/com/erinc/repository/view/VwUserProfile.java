package com.erinc.repository.view;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class VwUserProfile {

    String username;
    String name;
    String userimg;




}
