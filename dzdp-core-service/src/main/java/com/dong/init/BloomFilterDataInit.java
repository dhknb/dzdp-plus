package com.dong.init;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import com.dong.entity.SeckillVoucher;
import com.dong.entity.Shop;
import com.dong.handler.BloomFilterHandlerFactory;
import com.dong.service.ISeckillVoucherService;
import com.dong.service.IShopService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.dong.constant.Constant.BLOOM_FILTER_HANDLER_SHOP;
import static com.dong.constant.Constant.BLOOM_FILTER_HANDLER_VOUCHER;

/**
 * @program: 大众点评Plus - 高并发本地生活服务平台
 * @description: 布隆过滤器初始化
 * @author Dong
 **/
@Slf4j
@Order(1)
@Component
public class BloomFilterDataInit {
    
    @Resource
    private IShopService shopService;
    
    @Resource
    private ISeckillVoucherService seckillVoucherService;
    
    @Resource
    private BloomFilterHandlerFactory bloomFilterHandlerFactory;

    @PostConstruct
    public void init() {
        log.info("==========初始化商铺的布隆过滤器==========");
        List<Shop> shopList = shopService.list();
        for (Shop shop : shopList) {
            bloomFilterHandlerFactory.get(BLOOM_FILTER_HANDLER_SHOP).add(String.valueOf(shop.getId()));
        }
        log.info("==========初始化优惠券的布隆过滤器==========");
        List<SeckillVoucher> seckillVoucherlist = seckillVoucherService.list();
        for (SeckillVoucher seckillVoucher : seckillVoucherlist) {
            bloomFilterHandlerFactory.get(BLOOM_FILTER_HANDLER_VOUCHER).add(String.valueOf(seckillVoucher.getVoucherId()));
        }
    }
}
