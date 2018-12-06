package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Product;
import java.util.List;

public interface RecommendProductService {
    /**
     * 描述：推荐一个产品列表，几个产品都可以满足客户要求
     * @version 1.0
     **/
    public List<Product> recommendProducts(long orderId);

    /**
     * 描述：推荐一个组合产品，就是只有这个一个组合才能满足客户要求
     * @return
     */
    public List<Product> recommendProtfolios(long orderId);

}
