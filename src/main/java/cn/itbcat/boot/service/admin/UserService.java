package cn.itbcat.boot.service.admin;

import cn.itbcat.boot.entity.admin.Role;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.admin.UserRole;
import cn.itbcat.boot.repository.admin.RoleRepositor;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.repository.admin.UserRoleRepository;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.MD5;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Service
public class UserService {

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'CACHE_USER'";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepositor roleRepositor;

    @Autowired
    private UserRoleRepository userRoleRepository;

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

    public List<Role> getAllRole() {
        return roleRepositor.findAll();
    }

    @CacheEvict(value=ITBC.CACHE_NAME,key=CACHE_KEY)
    public String save(String roleId, User user) {

        String token = null;

        if(StringUtils.isNotBlank(roleId)){
            try {
                String userId = ITBC.getId();
                user.setUserId(userId);
                User currUser = ITBC.getCurrUser();
                user.setCreateUserId(user.getUserId());
                user.setCreateTime(new Date());
                String pass = new Sha256Hash(user.getPassword(), MD5.encodeSHAString(ITBC.PRODUCT_NAME)).toHex().toString();
                user.setPassword(pass);
                token = MD5.encodeSHAString("ITBC"+user.getUserId()+user.getUsername());
                user.setToken(token);
                userRepository.save(user);

                UserRole userRole = new UserRole();
                userRole.setId(ITBC.getId());
                userRole.setRoleId(roleId);
                userRole.setUserId(userId);
                userRoleRepository.save(userRole);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return token;
    }

    @CacheEvict(value=ITBC.CACHE_NAME,key=CACHE_KEY)
    public User save2(String roleId, User user) {
        if(StringUtils.isNotBlank(roleId)){
            try {
                User currUser = ITBC.getCurrUser();
                user.setCreateUserId(user.getUserId());
                user.setCreateTime(new Date());
                String pass = new Sha256Hash(user.getPassword(), MD5.encodeSHAString(ITBC.PRODUCT_NAME)).toHex().toString();
                user.setPassword(pass);
                user.setToken("");
                user = userRepository.save(user);

                UserRole userRole = new UserRole();
                userRole.setId(ITBC.getId());
                userRole.setRoleId(roleId);
                userRole.setUserId(user.getUserId());
                userRoleRepository.save(userRole);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Cacheable(value=ITBC.CACHE_NAME,key="'CACHE_USER_'+#userId")
    public User get(String userId) {
        return userRepository.findOne(userId);
    }

    public String getRoleId(String userId) {
        UserRole userRole = userRoleRepository.findByUserId(userId);
        return userRole.getRoleId();
    }

    @CachePut(value = ITBC.CACHE_NAME,key = "'CACHE_USER_'+#user.getUserId()")
    public User update(String roleId, User user) {
        try {
            User u = get(user.getUserId());
            userRoleRepository.deleteByUserId(user.getUserId());
            UserRole userRole = new UserRole();
            userRole.setId(ITBC.getId());
            userRole.setRoleId(roleId);
            userRole.setUserId(user.getUserId());
            userRoleRepository.save(userRole);
            u.setEmail(user.getEmail());
            u.setUsername(user.getUsername());
            u.setMobile(user.getMobile());
            u.setStatus(user.getStatus());
            u.setDeptId(user.getDeptId());
            u.setDeptName(user.getDeptName());
            u.setCreateTime(new Date());
            User currUser = ITBC.getCurrUser();
            u.setCreateUserId(user.getUserId());
            return userRepository.save(u);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @CachePut(value = ITBC.CACHE_NAME,key = "'CACHE_USER_'+#user.getUserId()")
    public User updateAvatar(User user){
        try {
            return userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @CacheEvict(value = ITBC.CACHE_NAME,key = "'CACHE_USER_'+#userId")//这是清除缓存.
    public void delete(String userId) {
        userRoleRepository.deleteByUserId(userId);
        userRepository.delete(userId);
    }

    public User getUserByToken(String token) {
        return userRepository.findUserByToken(token);
    }
}

