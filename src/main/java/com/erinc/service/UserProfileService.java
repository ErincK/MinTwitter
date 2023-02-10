package com.erinc.service;

import com.erinc.repository.UserProfileRepository;
import com.erinc.repository.entity.UserProfile;
import com.erinc.repository.view.VwUserProfile;
import com.erinc.utility.MyFactoryService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserProfileService extends MyFactoryService<UserProfileRepository, UserProfile,Long> {

    private UserProfileRepository userProfileRepository;
    public UserProfileService(){
        super(new UserProfileRepository());
        this.userProfileRepository = new UserProfileRepository();
    }

    public boolean existByUsername(String username){
        return getRepository().existByUsername(username);
    }

    public boolean doLogin(String username, String password){
        return getRepository().doLogin(username,password);
    }

    public Optional<UserProfile> findByUsername(String username){
        return getRepository().findByUsername(username);
    }

    /**
     * Kullanıcı listesini bir HashMap içinde Userid, View şeklinde saklayacak
     * bir kullanıcıya ulaşılmak istenildiğinde burada bilgileri çekilebilecektir.
     * @return
     */
    public Map<Long, VwUserProfile> findAllVwUserList(){
        Map<Long, VwUserProfile> result = new HashMap<>();
        findAll().forEach(x->{
            // UserId key, değer olarak map listin içinde var mı?
            //if(result.containsKey(x.getId()))
            result.put(x.getId(),VwUserProfile.builder()
                    .name(x.getName()+" "+x.getSurname())
                    .username(x.getUsername())
                    .userimg(x.getProfileimg())
                    .build());
        });
        return result;
    }

}
