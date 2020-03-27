package cn.zxs.mybatis.dao.impl;

import cn.zxs.mybatis.dao.UserDao;
import cn.zxs.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public User queryUserById(String id) {
        return sqlSession.selectOne("UserDao.queryUserById",id);
    }

    public List<User> queryUserAll() {
        return sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insert(User user) {
        Long Id = Long.parseLong(maxId())+1;
        user.setId(Long.toString(Id));
        sqlSession.insert("UserDao.insert",user);
    }

    public void delete(String id) {
        sqlSession.delete("UserDao.delete",id);
    }

    public void update(User user) {
        sqlSession.update("UserDao.update",user);
    }

    private String maxId() {
        return sqlSession.selectOne("UserDao.maxId");
    }
}
