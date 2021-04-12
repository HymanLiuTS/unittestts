package cn.codenest.powermockts.entity;

/**
 * @author ：Hyman
 * @date ：Created in 2021/4/2 13:57
 * @description：
 * @modified By：
 * @version: $
 */
public class User {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public int grow(int i) {
        if (!isAvailed(i)) {
            return -1;
        }
        age += i;
        return age;
    }

    private boolean isAvailed(int i) {
        return name != null;
    }

    public User() {

    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
