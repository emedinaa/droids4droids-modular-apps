package com.emedinaa.peruvianrecipes.core.mapper;

import com.emedinaa.peruvianrecipes.core.entity.User;
import com.emedinaa.peruvianrecipes.core.entity.UserEntity;

/**
 * Created by eduardo on 11/12/16.
 */
public class UserMapper {

    public User transform(UserEntity userEntity){
        User user= new User();
        if(userEntity==null) return user;
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setName(userEntity.getName());
        return  user;
    }
}
