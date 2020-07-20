package mybatis.dao.impl;

import mybatis.dao.UserDao;
import mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

public class UserDaoImpl implements UserDao {


    private final SqlSession sqlSession;

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
        long Id = Long.parseLong(maxId())+1;
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
