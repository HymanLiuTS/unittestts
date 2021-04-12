package cn.codenest.powermockts.respository;

import cn.codenest.powermockts.entity.User;
import cn.codenest.powermockts.exception.InvailedUserException;
import cn.codenest.powermockts.mapper.UserMapper;
import cn.codenest.powermockts.util.MathUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:06
 * @description：
 * （1）使用PowerMockRunner.class启动最基本的powermock
 *  (2) 使用mock进行模拟，验证公用的方法
 * @modified By：
 * @version: $
 */
/*表明用 PowerMockerRunner来运行测试用例，否则无法使用PowerMock*/
@RunWith(PowerMockRunner.class)
/*准备要测试的类*/
@PrepareForTest({UserRespository.class, MathUtil.class})
/*为了解决使用powermock后，提示classloader错误*/
@PowerMockIgnore("javax.management.*")
public class UserRespositoryTest {

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserRespository userRespository;

    @Test
    public void createTest() {
        User user=new User(17,"Hyman");
        /*mock方法中要先when再return*/
        PowerMockito.when(userMapper.create(user)).thenReturn(1);
        int flag=userRespository.create(user);
        assertEquals(1,flag);
        User user2=new User(1,"Hyman");
        flag=userRespository.create(user2);
        assertEquals(0,flag);
    }

    @Test
    public void deleteTest() throws InvailedUserException {
        /*mock方法中要先when再return*/
        PowerMockito.when(userMapper.delete(-1)).thenThrow(new InvailedUserException("用户ID无效"));
        boolean flag=userRespository.delete(-1);
        assertEquals(false,flag);
    }

    /**
     * create by: Hyman
     * description: 模拟返回为void的方法
     * create time: 2021/4/12
     */
    @Test
    public void doNothingTest() throws Exception {
        /*方法1*/
        PowerMockito.doNothing().when(userMapper,"doNothing",1);
        /*方法2*/
        PowerMockito.doNothing().when(userMapper).doNothing(1);
        userRespository.doNothing(1);
    }
}
