package cn.codenest.powermockts.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.*;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 16:23
 * @description： (1)使用powermock模拟静态方法
 * @modified By：
 * @version: $
 */
/*表明用 PowerMockerRunner来运行测试用例，否则无法使用PowerMock*/
@RunWith(PowerMockRunner.class)
/*准备要测试的类,在模拟静态方法时，这里一定要写*/
@PrepareForTest({MathUtil.class})
/*为了解决使用powermock后，提示classloader错误*/
@PowerMockIgnore("javax.management.*")
public class MathUtilTest {

    /**
     * create by: Hyman
     * description: 进行静态方法的模拟时，需要在@PrepareForTest注解中加上需要模拟的类
     * create time: 2021/4/12
     */
    @Test
    public void addTest() {
        PowerMockito.mockStatic(MathUtil.class);
        PowerMockito.when(MathUtil.add(1,2)).thenReturn(4);
        assertEquals(4,MathUtil.add(1,2));
    }
}
