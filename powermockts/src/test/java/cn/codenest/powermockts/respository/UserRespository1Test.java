package cn.codenest.powermockts.respository;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 15:07
 * @description：
 * @modified By：
 * @version: $
 */

import cn.codenest.powermockts.entity.User;
import cn.codenest.powermockts.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import  cn.codenest.powermockts.mapper.impl.UserMapperImpl;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.junit.Assert.assertEquals;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 14:06
 * @description：
 * （1）SpringJUnit4ClassRunner+SpringBootTest构建支持spring ioc的环境
 * （2）使用DependencyInjectionTestExecutionListener+MockitoTestExecutionListener配置支持可以装在spring ioc中的bean
 * （3）使用spy注解引用spring ioc中的bean
 * @modified By：
 * @version: $
 */
/*用 SpringJUnit4ClassRunner和UserRespository配合使用，可以使用spring ioc，否则无法使用PowerMock*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
/*准备要测试的类*/
@PrepareForTest({UserRespository.class})
/*为了解决使用powermock后，提示classloader错误*/
@PowerMockIgnore("javax.management.*")
/* DependencyInjectionTestExecutionListener能够保证可以通过依赖注入的方式用spring ioc中的bean
*  MockitoTestExecutionListener 是使用spring ioc bean时，为了避免出现MissingMethodInvocationException
*  其他有啥用还不清楚
* */
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        //DirtiesContextTestExecutionListener.class,
        //TransactionalTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        //DbUnitTestExecutionListener.class
})
public class UserRespository1Test {

    /*Spy和Mock的区别是：
    *（1）Spy需要注解到一个实例上面，这个实例要么自己new一个
    * 要么使用spring ioc中的bean
    *（2）spy模拟的对象在没有定义返回方法时，会调用原来对象的方法
    * */
    @Spy
    @Autowired
    //UserMapper userMapper = new UserMapperImpl();
    UserMapper userMapper;

    /*当InjectMocks和Autowired同时注解bean，InjectMocks会无效*/
    @InjectMocks
    //@Autowired
    UserRespository userRespository;


    @Test
    public void createTest() {
        User user = new User(-1, "Hyman");
        PowerMockito.when(userMapper.create(user)).thenReturn(1);
        int flag = userRespository.create(user);
        assertEquals(1, flag);
        User user2 = new User(1, "Hyman");
        flag = userRespository.create(user2);
        assertEquals(1, flag);
    }

}
