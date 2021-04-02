package cn.codenest.powermockts.mapper.impl;

import cn.codenest.powermockts.entity.User;
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
}
