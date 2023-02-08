package com.erinc.controller;

import com.erinc.repository.entity.UserProfile;
import com.erinc.service.UserProfileService;

import java.util.Scanner;

public class UserProfileController {
    private Scanner scanner;
    private UserProfileService userProfileService;


    public UserProfileController(){
        scanner = new Scanner(System.in);
        userProfileService = new UserProfileService();
    }


    public void register(){
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("**********************************");
        System.out.println("*****     REGISTER PAGE    *******");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("User name..............: ");
        String username = scanner.nextLine();
        System.out.println("Password...............: ");
        String password = scanner.nextLine();
        System.out.println("Password Correction....: ");
        String repassword = scanner.nextLine();

        if(repassword.equals(password)){
            boolean isUsernameExist = userProfileService.existByUsername(username);
            if(isUsernameExist)
                System.out.println("Bu Kullanici Adi Kullanilmaktadir.");
        }else {
            userProfileService.save(UserProfile.builder().username(username).password(password).build());
            System.out.println("Kullanici Basari ile Kaydedildi.");
        }

    }
}
