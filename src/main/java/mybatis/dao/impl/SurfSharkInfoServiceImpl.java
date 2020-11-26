package mybatis.dao.impl;

import mybatis.dao.SurfSharkInfoService;
import mybatis.pojo.SurfSharkInfo;
import org.apache.ibatis.session.SqlSession;

public class SurfSharkInfoServiceImpl implements SurfSharkInfoService {
    private final SqlSession sqlSession;

    public SurfSharkInfoServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertSurfSharkInfo(SurfSharkInfo surfSharkInfo) {
        sqlSession.insert("SurfSharkInfo.insert",surfSharkInfo);
    }
}
