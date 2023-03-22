package cn.zeroclian.springframework.bean;

/**
 * @author Justin
 */
public class UserService {

    private String uId;
    private UserDao userDao;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uid='" + uId + '\'' +
                '}';
    }
}