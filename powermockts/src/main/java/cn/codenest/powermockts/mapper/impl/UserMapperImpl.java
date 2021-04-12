package cn.codenest.powermockts.mapper.impl;

import cn.codenest.powermockts.entity.User;
import cn.codenest.powermockts.exception.InvailedUserException;
import cn.codenest.powermockts.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:53
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public int create(User user) {
        if (user.getAge() < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean delete(int userId) throws InvailedUserException {
        if (userId <= 0) {
            throw new InvailedUserException("用户ID无效");
        }
        return true;
    }

    @Override
    public void doNothing(int userId) {
        System.out.println("doNothing");
    }
}
