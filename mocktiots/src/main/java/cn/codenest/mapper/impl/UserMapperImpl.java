package cn.codenest.mapper.impl;

import cn.codenest.entity.User;
import cn.codenest.mapper.UserMapper;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:53
 * @description：
 * @modified By：
 * @version: $
 */

public class UserMapperImpl implements UserMapper {

    @Override
    public int create(User user) {
        if (user.getAge() < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean delete(int userId) {
        return true;
    }

    @Override
    public void doNothing(int userId) {
        System.out.println("doNothing");
    }
}
