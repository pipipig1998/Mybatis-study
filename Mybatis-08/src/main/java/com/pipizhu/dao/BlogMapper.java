package com.pipizhu.dao;

import com.pipizhu.pojo.Blog;

import java.util.List;
import java.util.Map;

    public interface BlogMapper {
        int addBlog(Blog blog);
        List<Blog> queryBlogIF(Map map);
        List<Blog>chooseBlogChoose(Map map);
        int updateBlog(Map map);
        List<Blog> queryBlogByForeach(Map map);
    }
