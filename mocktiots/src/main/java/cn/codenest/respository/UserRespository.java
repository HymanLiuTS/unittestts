package cn.codenest.respository;


import cn.codenest.entity.User;
import cn.codenest.mapper.UserMapper;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:41
 * @description：
 * @modified By：
 * @version: $
 */

public class UserRespository {

    public UserRespository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    UserMapper userMapper;

    public int create(User user) {
        return userMapper.create(user);
    }

    public boolean delete(int userID) {
        return userMapper.delete(userID);
    }

    public void doNothing(int userId) {
        userMapper.doNothing(userId);
    }

}
