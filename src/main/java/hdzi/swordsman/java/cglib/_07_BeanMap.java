package hdzi.swordsman.java.cglib;

import net.sf.cglib.beans.BeanMap;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _07_BeanMap {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        _07_BeanMap bean = new _07_BeanMap();
        bean.setUsername("tao");
        bean.setPassword("jin");

        BeanMap beanMap = BeanMap.create(bean);

        System.out.println(beanMap);
    }
}
