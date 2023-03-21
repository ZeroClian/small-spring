package cn.zeroclian.springframework.Bean;

/**
 * @author Justin
 */
public class UserService {

    private String uid;
    private UserDao userDao;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uid));
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
