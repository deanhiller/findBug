package biz.xsoftware.caching.api;

import java.util.concurrent.CompletableFuture;

public interface CachingService {

    public CachedResponse fetchCached(CachingRequest request);
}
