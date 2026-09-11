package com.dong.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 滚动-结果
 * @author Dong
 **/
@Data
public class ScrollResult {
    private List<?> list;
    private Long minTime;
    private Integer offset;
}
