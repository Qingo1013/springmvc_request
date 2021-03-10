package cn.tulingxueyuan.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class User {

    private Integer id;
    private String name;
    private String[] alias; // 外号
    private List<String> hobbies; //爱好
    private Map<String,String> relatives; //亲属
    private Role role;
    private List<User> friends; //朋友
    //Alt+insert getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getRelatives() {
        return relatives;
    }

    public void setRelatives(Map<String, String> relatives) {
        this.relatives = relatives;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias=" + Arrays.toString(alias) +
                ", hobbies=" + hobbies +
                ", relatives=" + relatives +
                ", role=" + role +
                ", friends=" + friends +
                '}';
    }
}
