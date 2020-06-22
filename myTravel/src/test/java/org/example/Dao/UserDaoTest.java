package org.example.Dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao;
    @Before
    public void init(){
        userDao=new UserDao();
    }
    @After
    public void destory(){
        userDao=null;
    }

    @Test
    public void testSave() {
        userDao.save();
    }

    @Test
    public void testuUpdate() {
        userDao.update();
    }

    @Test
    public void testDelete() {
        userDao.delete();
    }

    @Test
    public void testFind() {
        userDao.find();
    }
}