package cn.codenest.powermockts.respository;

import cn.codenest.powermockts.entity.User;
import cn.codenest.powermockts.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.junit.Assert.*;

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
@PrepareForTest({UserRespository.class})
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
        PowerMockito.when(userMapper.create(user)).thenReturn(1);
        int flag=userRespository.create(user);
        assertEquals(1,flag);
        User user2=new User(1,"Hyman");
        flag=userRespository.create(user2);
        assertEquals(0,flag);
    }

}
