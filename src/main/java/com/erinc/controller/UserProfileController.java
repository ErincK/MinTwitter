package com.erinc.controller;

import com.erinc.repository.entity.UserProfile;
import com.erinc.service.UserProfileService;

import java.util.Scanner;

public class UserProfileController {
    private Scanner scanner;
    private UserProfileService userProfileService;
    private TweetController tweetController;


    public UserProfileController(){
        scanner = new Scanner(System.in);
        userProfileService = new UserProfileService();
        tweetController = new TweetController();
    }


    public void register(){
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("**********************************");
        System.out.println("*****     REGISTER PAGE    *******");
        System.out.println("**********************************");
        System.out.println();
        boolean state;
        do{
            System.out.println("User name..............: ");
            String username = scanner.nextLine();
            System.out.println("Password...............: ");
            String password = scanner.nextLine();
            System.out.println("Password Correction....: ");
            String repassword = scanner.nextLine();
            if(repassword.equals(password)){
                boolean isUsernameExist = userProfileService.existByUsername(username);
                if(isUsernameExist){
                    System.out.println("Bu Kullanici Adi Kullanilmaktadir.");
                    state = true;
                }else{
                    userProfileService.save(UserProfile.builder().username(username).password(password).build());
                    System.out.println("Kullanici Basari ile Kaydedildi.");
                    state = true;
                }
            }else {
                System.out.println("Sifreler Uyusmamaktadir.");
                state = true;
            }
        }while(state);





    }

    public void login(){
        System.out.println("******************************");
        System.out.println("*****     LOGIN PAGE     *****");
        System.out.println("******************************");
        System.out.println();
        System.out.print("Username........: ");
        String username = scanner.nextLine();
        System.out.print("Password........: ");
        String password = scanner.nextLine();
        /**
         * Kullanıcı adı ve şifre doğrulanırken kullanıcıya, "Sifre yanlıştır", yada "Kulllanıcı adi yanlıştır.."
         * gibi bilgi geçmeyin.. "
         */
        boolean login = userProfileService.doLogin(username,password);
        if(login) {
            System.out.println("Giris Basarili...");
            tweetController.userPage(username);
        }else {
            System.out.println("Bir seyler yanlis...");
        }


    }





}
