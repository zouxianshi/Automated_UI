package mybatis.dao;

import mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User queryUserById(String id);

    /**
     * 查询全部
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增记录
     * @param user
     */
    public void insert(User user);

    /**
     * 删除记录
     * @param id
     */
    public void delete(String id);

    /**
     * 更新记录
     * @param user
     */
    public void update(User user);

}
