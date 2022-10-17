package biz.xsoftware.impl.usersvc;

import biz.xsoftware.caching.api.CachedResponse;
import biz.xsoftware.caching.api.CachingRequest;
import biz.xsoftware.caching.api.CachingService;

import java.util.concurrent.TimeUnit;

public class BusinessLogic {

    private CachingService cacheService;

    public BusinessLogic(CachingService cacheService) {
        this.cacheService = cacheService;
    }

    public MyOrder fetchOrder(int id) {
        CachingRequest req = new CachingRequest();
        req.setId(id);
        try {
            CachedResponse cachedResponse = cacheService.fetchCached(req);

            MyOrder order = new MyOrder();
            order.setName(cachedResponse.getName());
            return order;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
