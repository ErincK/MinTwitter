package com.erinc.repository;

import com.erinc.repository.entity.UserProfile;
import com.erinc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;

public class UserProfileRepository extends MyFactoryRepository<UserProfile, Long> {
    public UserProfileRepository(){
        super(new UserProfile());
    }

    public boolean existByUsername(String username){
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("UserProfile.existByUsername", Boolean.class);
        typedQuery.setParameter("username",username);
        Boolean result = typedQuery.getSingleResult();
        return result;
    }
}
