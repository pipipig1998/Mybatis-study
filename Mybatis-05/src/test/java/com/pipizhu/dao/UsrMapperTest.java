package com.pipizhu.dao;

import com.pipizhu.Utils.MybatisUtils;
import com.pipizhu.pojo.Usr;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UsrMapperTest {
    @Test
    public void getUsr(){
        SqlSession session = MybatisUtils.getSqlSession();
        UsrMapper mapper = session.getMapper(UsrMapper.class);
        List<Usr> usr = mapper.getUsr();
        for (Usr usr1 : usr) {
            System.out.println(usr1);
        }
        session.close();
    }
    @Test
    public void getUsrById(){
        SqlSession session = MybatisUtils.getSqlSession();
        UsrMapper sessionMapper = session.getMapper(UsrMapper.class);
        Usr usr = sessionMapper.getUsrById(3);
        System.out.println(usr);
        session.close();
    }
    @Test
    public void addUsr(){
        SqlSession session = MybatisUtils.getSqlSession();
        UsrMapper sessionMapper = session.getMapper(UsrMapper.class);
        int result=sessionMapper.addUsr(new Usr(8,"小红","888888"));
        session.close();
    }
    @Test
    public  void delete(){

        SqlSession session = MybatisUtils.getSqlSession();
        UsrMapper sessionMapper = session.getMapper(UsrMapper.class);
        int i = sessionMapper.deleteUsr(5);
        session.close();
    }
}
