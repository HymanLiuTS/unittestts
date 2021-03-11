package cn.codenest.powermockts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/11 17:22
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class MockExample {

    @Mock
    private MockMapper mockMapper;

    @InjectMocks
    private MockServiceImpl mockService;

    @Test
    public void testSelectAppAdvertisementList() {

        PowerMockito.when(mockMapper.count(1)).thenReturn(1);
        int i = mockService.count(1);
        i = mockService.count(2);
        System.out.println(i);

    }

}
