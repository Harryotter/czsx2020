package org.example.p02service;

import org.example.p03Dao.UserDao;
import org.example.p04bean.User;

//service业务层，调用数据访问层
public class UserService {

    public int login(User user) throws Exception {
        //创建数据访问层对象
        UserDao userDao=new UserDao();
        //根据账号密码查找
        int num=userDao.findByUsernamePassword(user.getUsername(),user.getPassword());
        return num;
    }

    public int register(User user) throws Exception {
        //因为账号是不能相同的，把数据保存之前应该先判断
        //第一步：查找
        UserDao userDao=new UserDao();
        //第二步：根据查找结果，处理
        int count=userDao.findByUserName(user.getUsername());
        //三元表达式
//        return count>0 ?-1:1;
       if(count==0){
            userDao.save(user);
            return 1;
        }else{
            return -1;

       }
//       return count;
    }
}
