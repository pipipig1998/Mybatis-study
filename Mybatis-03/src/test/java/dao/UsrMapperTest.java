package dao;

import com.pipizhu.dao.UsrMapper;
import com.pipizhu.pojo.Usr;
import com.pipizhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsrMapperTest {
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
