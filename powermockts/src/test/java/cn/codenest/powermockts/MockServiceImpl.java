package cn.codenest.powermockts;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/11 17:28
 * @description：
 * @modified By：
 * @version: $
 */
public class MockServiceImpl {

    @Autowired
    private MockMapper mockMapper;

    public int count(int i) {
        return mockMapper.count(i);
    }
}
