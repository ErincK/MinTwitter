package com.erinc;

import com.erinc.controller.UserProfileController;

import java.util.Scanner;

public class TweetterApplication {
    public static void main(String[] args) {
        int secim;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("************************************");
            System.out.println("****    TWEET APPLICATION      *****");
            System.out.println("************************************");
            System.out.println();
            System.out.println("1- Sign in");
            System.out.println("2- Log in");
            System.out.println("3- View Tweets");
            System.out.println("0- Exit");
            System.out.println("Secim yapiniz....: ");
            secim = scanner.nextInt();

            switch (secim){
                case 1:new UserProfileController().register();
                    break;
                case 2:new UserProfileController().login();
                    break;
                case 3:
                    break;
            }
        }while(secim!=0);
        System.out.println("SEE YOU AGAIN!!");








    }
}