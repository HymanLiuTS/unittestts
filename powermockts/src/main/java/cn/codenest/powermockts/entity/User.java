package cn.codenest.powermockts.entity;

import lombok.Data;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 13:57
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class User {

    private int age;

    private String name;

    public User() {

    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
