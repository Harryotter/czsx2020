package org.example.Dao;



public class UserDao {
    public void save(){
        System.out.println("保存");
    }
    public void update(){
        int a=12;
        int b=2;
        System.out.println("更新");
        System.out.println(a/b);
    }
    public void delete(){
        System.out.println("删除");
    }
    public void find(){
        System.out.println("查找");
    }
}
