package com.pipizhu.dao;

import com.pipizhu.pojo.Usr;
import com.pipizhu.Utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UsrMapperTest {
    static Logger logger = Logger.getLogger(UsrMapperTest.class);

    @Test
    public void  getUsrByRowbounds(){
        SqlSession session = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        List<Usr> list = session.selectList("com.pipizhu.dao.UsrMapper.getUsrByRowbounds", null, rowBounds);
        for (Usr usr : list) {
            System.out.println(usr);
        }
        session.close();
    }


    @Test
    public void getUsrByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper mapper = sqlSession.getMapper(UsrMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex",1);
        map.put("pagesize",2);
        List<Usr> list = mapper.getUsrByLimit(map);
        for (Usr usr : list) {
            System.out.println(usr);

        }
        sqlSession.close();
    }


    @Test
    public void testLog4j(){
        logger.info("info:进入了log4j方法");
        logger.debug("debug:进入debug模式");
        logger.error("error:进入error模式");

    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第一种方式
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        List<Usr> usrList = usrMapper.getUsrList();
        for (Usr usr : usrList) {
            System.out.println(usr);
        }
        sqlSession.close();
    }
    @Test
    public void getUsrById(){

        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UsrMapper mapper = sqlSession.getMapper(UsrMapper.class);
        Usr usr=mapper.getUsrById(2);
        System.out.println(usr.getName());
        sqlSession.close();
    }
    @Test
    public void addUsr(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        int num=usrMapper.addUsr(new Usr(4,"小明","666666"));
        System.out.println(num);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUsr(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        usrMapper.updateUsr(new Usr(1,"李武","password"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUsr(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        usrMapper.deleteUsr(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUsr2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userid",4);
        map.put("username","hhahahh");
        map.put("password","dududu");

        usrMapper.addUsr2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUsrLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsrMapper usrMapper = sqlSession.getMapper(UsrMapper.class);
        String value="李%";
        List<Usr> usrList = usrMapper.getUsrLike(value);
        for (Usr usr : usrList) {
            System.out.println(usr);
        }
        sqlSession.close();
    }
}
