package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.repository.UserRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean checkName(String userName){
        User user = userRepository.findUserByEmail(userName);
        if(null == user){
            return false;
        }
        return true;
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

}
