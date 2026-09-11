package com.dong.controller;


import jakarta.annotation.Resource;
import com.dong.dto.Result;
import com.dong.entity.ShopType;
import com.dong.service.IShopTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 商铺类型api
 * @author Dong
 **/
@RestController
@RequestMapping("/shop-type")
public class ShopTypeController {
    @Resource
    private IShopTypeService typeService;

    @GetMapping("list")
    public Result queryTypeList() {
        List<ShopType> typeList = typeService
                .query().orderByAsc("sort").list();
        return Result.ok(typeList);
    }
}
