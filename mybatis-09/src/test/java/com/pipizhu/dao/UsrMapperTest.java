package com.pipizhu.dao;

import com.pipizhu.Utils.MybatisUtils;
import com.pipizhu.pojo.Usr;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UsrMapperTest {

    @Test
    public void queryUsrById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper mapper = sqlSession.getMapper(UsrMapper.class);
        Usr usr = mapper.queryUsrById("1");
        System.out.println(usr);

        Usr usr2 = mapper.queryUsrById("1");
        System.out.println(usr==usr2);

        sqlSession.close();
    }
}
