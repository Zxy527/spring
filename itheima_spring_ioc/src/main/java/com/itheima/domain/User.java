package com.itheima.domain;

/**
 * @Author: zxy
 * @Date: 2022/4/2 - 04 - 02 - 9:53
 * @Description: com.itheima.domain
 * @version: 1.0
 */
public class User {
    private String name;//name
    private String address;//address

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
