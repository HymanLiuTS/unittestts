package cn.codenest.powermockts.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/12 18:35
 * @description：
 * @modified By：
 * @version: $
 */
/*表明用 PowerMockerRunner来运行测试用例，否则无法使用PowerMock*/
@RunWith(PowerMockRunner.class)
/*准备要测试的类*/
@PrepareForTest({User.class})
/*为了解决使用powermock后，提示classloader错误*/
@PowerMockIgnore("javax.management.*")
public class UserTest {


    /**
     * create by: Hyman
     * description: 使用mock出的对象调用私有的方法等等
     * create time: 2021/4/12
     */
    @Test
    public void testSetAge1() throws Exception {
        User user = new User();
        /*给私有的成员赋值*/
        Whitebox.setInternalState(user, "age", 18);

        User userMock = PowerMockito.mock(User.class);
        /*声明模拟时调用真实的方法*/
        PowerMockito.when(userMock.grow(1)).thenCallRealMethod();
        /*模拟私有的方法*/
        PowerMockito.when(userMock, "isAvailed", 1).thenReturn(true);
        int result = userMock.grow(1);
        assertEquals(1, result);
    }

    /**
     * create by: Hyman
     * description: 使用spy对已经存在的对象监视，调用其私有方法等等
     * create time: 2021/4/12
     */
    @Test
    public void testSetAge2() throws Exception {
        User user = new User();
        /*给私有的成员赋值*/
        Whitebox.setInternalState(user, "age", 18);

        User userMock = PowerMockito.spy(user);
        /*模拟私有的方法*/
        PowerMockito.when(userMock, "isAvailed", 1).thenReturn(true);
        int result = userMock.grow(1);
        assertEquals(19, result);
    }

    /**
     * create by: Hyman
     * description: 测试私有方法
     * create time: 2021/4/12
     */
    @Test
    public void testIsAvailed() throws Exception {
        User user = new User();
        /*方法一：  使用反射来测试私有方法*/
        Method method = PowerMockito.method(User.class, "isAvailed", int.class);
        boolean result = (boolean) method.invoke(user, 1);
        assertEquals(false, result);

        /*方法二： 使用 Whitebox 来执行*/
        result = Whitebox.invokeMethod(user, "isAvailed", 1);
        assertEquals(false, result);
    }

    /**
     * create by: Hyman
     * description: 模拟构造方法
     * create time: 2021/4/12
     */
    @Test
    public void testUser() throws Exception {
        User user=new User();
        PowerMockito.whenNew(User.class).withNoArguments().thenReturn(user);
    }
}
