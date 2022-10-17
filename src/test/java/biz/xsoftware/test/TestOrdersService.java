package biz.xsoftware.test;

import biz.xsoftware.caching.api.CachedResponse;
import biz.xsoftware.caching.api.CachingRequest;
import biz.xsoftware.orders.api.OrderRequest;
import biz.xsoftware.orders.api.OrderResponse;
import biz.xsoftware.orders.api.OrdersService;
import biz.xsoftware.test.FeatureTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestOrdersService extends FeatureTest {

	@Override
	protected void tearDown() throws Exception {
		
	}

	@Test
	public void testFetchOrder() throws ExecutionException, InterruptedException, TimeoutException {
		//populate mock with data here!!!

		CachedResponse cacheResponse = new CachedResponse();
		cacheResponse.setName("my name");
		mockCacheSvc.addResponse(cacheResponse);

		//create request for service here

		OrderRequest request = new OrderRequest();
		request.setId(4);
		OrderResponse orderResponse = ordersSvc.readOrder(request);

		Assert.assertEquals(cacheResponse.getName(), orderResponse.getName());

		CachingRequest cachingRequest = mockCacheSvc.getRequests().get(0);
		Assert.assertEquals(request.getId(), cachingRequest.getId());

	}

}
