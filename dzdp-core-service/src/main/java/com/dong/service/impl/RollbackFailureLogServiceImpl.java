package com.dong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dong.entity.RollbackFailureLog;
import com.dong.mapper.RollbackFailureLogMapper;
import com.dong.service.IRollbackFailureLogService;
import org.springframework.stereotype.Service;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 回滚失败日志 接口实现
 * @author Dong
 **/
@Service
public class RollbackFailureLogServiceImpl extends ServiceImpl<RollbackFailureLogMapper, RollbackFailureLog>
        implements IRollbackFailureLogService {
}