package cn.codenest.mapper;

import cn.codenest.entity.User;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 13:55
 * @description：
 * @modified By：
 * @version: $
 */

public interface UserMapper {

    int create(User user);

    boolean delete(int userId);

    void doNothing(int userId);
}