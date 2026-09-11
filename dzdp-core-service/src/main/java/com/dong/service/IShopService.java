package com.dong.service;

import com.dong.dto.Result;
import com.dong.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 商铺 接口
 * @author Dong
 **/
public interface IShopService extends IService<Shop> {

    Result saveShop(Shop shop);
    
    Result queryById(Long id);

    Result update(Shop shop);

    Result queryShopByType(Integer typeId, Integer current, Double x, Double y);
}
