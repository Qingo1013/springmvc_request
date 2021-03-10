package cn.tulingxueyuan.entity;

//UserDTO（User Data Transfer Object 用户数据传输对象）
public class UserDTO {
    private User user;
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user=" + user +
                ", role=" + role +
                '}';
    }
}
