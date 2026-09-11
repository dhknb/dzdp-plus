package com.dong.service;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 令牌
 * @author Dong
 **/
public interface ISeckillAccessTokenService {
  
    boolean isEnabled();
 
    String issueAccessToken(Long voucherId, Long userId);
    
    boolean validateAndConsume(Long voucherId, Long userId, String token);
}