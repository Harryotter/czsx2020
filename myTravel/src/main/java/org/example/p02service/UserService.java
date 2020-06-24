package org.example.p02service;

import org.example.p03Dao.UserDao;
import org.example.bean.User;

//service业务层，调用数据访问层
public class UserService {

    public int login(User user) throws Exception {
        //创建数据访问层对象
        UserDao userDao=new UserDao();
        //根据账号密码查找
        int num=userDao.findByUsernamePassword(user.getUsername(),user.getPassword());
        return num;
    }
}
