package ua.mapper;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.entity.UserEntity;

public interface UserMapper {


    public static User toUser(UserEntity entity){
        return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
    }
}
