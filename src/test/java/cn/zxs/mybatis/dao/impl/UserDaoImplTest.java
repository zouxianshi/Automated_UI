package cn.zxs.mybatis.dao.impl;

import mybatis.dao.UserDao;
import mybatis.dao.impl.UserDaoImpl;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoImplTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @BeforeMethod
    public void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void testQueryUserById() {
        System.out.println(this.userDao.queryUserById("1"));
    }

    @Test
    public void testQueryUserAll() {
        List<User> userList = this.userDao.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("evan");
        this.userDao.insert(user);
        this.sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("evanjin");
        user.setId("1");
        this.userDao.update(user);
        this.sqlSession.commit();
    }

    @Test
    public void testDelete() {
        this.userDao.delete("4");
        this.sqlSession.commit();
    }


}