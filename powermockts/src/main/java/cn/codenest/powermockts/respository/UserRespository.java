package cn.codenest.powermockts.respository;

import cn.codenest.powermockts.entity.User;
import cn.codenest.powermockts.exception.InvailedUserException;
import cn.codenest.powermockts.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:41
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class UserRespository {

    @Autowired
    UserMapper userMapper;

    public int create(User user) {
        return userMapper.create(user);
    }

    public boolean delete(int userID) {
        try {
            return userMapper.delete(userID);
        } catch (InvailedUserException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void doNothing(int userId) {
        userMapper.doNothing(userId);
    }

}
