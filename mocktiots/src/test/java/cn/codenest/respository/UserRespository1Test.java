package cn.codenest.respository;

import cn.codenest.entity.User;
import cn.codenest.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:06
 * @description：
 * （1）脱离spring使用原生的mocktio进行模拟
 * （2）mocktio只能模拟公共方法，无法模拟静态方法、私有方法等等
 * @modified By：
 * @version: $
 */
public class UserRespository1Test {

    private UserMapper userMapperMock;
    private UserRespository userRespository;

    /**
     * create by: Hyman
     * description: 在setup中进行相关模拟的创建
     * create time: 2021/4/13
     */
    @Before
    public void setUp() {
        userMapperMock=mock(UserMapper.class);
        userRespository=new UserRespository(userMapperMock);
    }

    @Test
    public void createTest() {
        User user = new User(-1, "Hyman");
        when(userMapperMock.create(user)).thenReturn(1);
        int flag = userRespository.create(user);
        assertEquals(1, flag);
        User user2 = new User(1, "Hyman");
        when(userMapperMock.create(user2)).thenReturn(0);
        flag = userRespository.create(user2);
        assertEquals(0, flag);
    }

}
