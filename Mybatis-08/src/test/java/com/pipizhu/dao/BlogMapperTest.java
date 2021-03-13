package com.pipizhu.dao;

import com.pipizhu.Utils.IDutils;
import com.pipizhu.Utils.MybatisUtils;
import com.pipizhu.pojo.Blog;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {
    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog =new Blog();
        blog.setId(IDutils.getID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("皮皮猪");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        blogMapper.addBlog(blog);
        sqlSession.commit();

        blog.setId(IDutils.getID());
        blog.setTitle("Spring如此简单");
        blog.setAuthor("皮皮猪");
        blogMapper.addBlog(blog);
        sqlSession.commit();
        blog.setId(IDutils.getID());
        blog.setTitle("微服务如此简单");
        blog.setAuthor("皮皮猪");
        blogMapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void queryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Spring如此简单");
        List<Blog> blogs = blogMapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void chooseBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title","java如此简单");
        map.put("author","皮皮猪");
        List<Blog> blogs = blogMapper.chooseBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("id","4a39de22f1ed48eeae8b69eb09c3db47");
//        map.put("title","Spring如此简单2");
        map.put("author","小皮皮猪");
        blogMapper.updateBlog(map);

        sqlSession.close();
    }
    @Test
    public void queryBlogByForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
        blogMapper.queryBlogByForeach(map);
        sqlSession.close();
    }
}
