package cn.codenest.powermockts.mapper;

import cn.codenest.powermockts.entity.User;
import cn.codenest.powermockts.exception.InvailedUserException;
import org.springframework.stereotype.Component;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 13:55
 * @description：
 * @modified By：
 * @version: $
 */

public interface UserMapper {
    int create(User user);
    boolean delete(int userId) throws InvailedUserException;

    void doNothing(int userId);
}