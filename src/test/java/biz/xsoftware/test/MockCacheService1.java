package biz.xsoftware.test;

import biz.xsoftware.caching.api.CachedResponse;
import biz.xsoftware.caching.api.CachingRequest;
import biz.xsoftware.caching.api.CachingService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MockCacheService1 implements CachingService {

    private List<Object> responses = new ArrayList<>();
    private List<CachingRequest> requests = new ArrayList<>();

    @Override
    public CachedResponse fetchCached(CachingRequest request) {
        requests.add(request);
        if(responses.size() <= 0)
            throw new IllegalStateException("not enough responses filled in by test");

        Object o = responses.get(0);
        if(o instanceof RuntimeException) {
            throw (RuntimeException)o;
        }

        return (CachedResponse) o;
    }

    public void addResponse(CachedResponse response) {
        this.responses.add(response);
    }

    public void addExceptionResponse(RuntimeException e) {
        this.responses.add(e);
    }

    public List<CachingRequest> getRequests() {
        return requests;
    }
}
