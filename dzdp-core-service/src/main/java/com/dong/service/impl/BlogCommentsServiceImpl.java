package com.dong.service.impl;

import com.dong.entity.BlogComments;
import com.dong.mapper.BlogCommentsMapper;
import com.dong.service.IBlogCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 博客评论接口实现
 * @author Dong
 **/
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments> implements IBlogCommentsService {

}
