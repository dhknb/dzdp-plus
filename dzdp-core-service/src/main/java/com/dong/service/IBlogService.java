package com.dong.service;

import com.dong.dto.Result;
import com.dong.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 博客接口
 * @author Dong
 **/
public interface IBlogService extends IService<Blog> {

    Result queryHotBlog(Integer current);

    Result queryBlogById(Long id);

    Result likeBlog(Long id);

    Result queryBlogLikes(Long id);

    Result saveBlog(Blog blog);

    Result queryBlogOfFollow(Long max, Integer offset);

}
