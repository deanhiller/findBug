package biz.xsoftware.orders.api;


import java.util.concurrent.CompletableFuture;

public interface OrdersService
{


	public OrderResponse readOrder(OrderRequest request);
}
