package biz.xsoftware.impl.usersvc;

import biz.xsoftware.orders.api.OrderRequest;
import biz.xsoftware.orders.api.OrderResponse;
import biz.xsoftware.orders.api.OrdersService;

import java.util.concurrent.CompletableFuture;

public class OrdersController implements OrdersService {

    private BusinessLogic logic;

    public OrdersController(BusinessLogic logic) {
        this.logic = logic;
    }

    @Override
    public OrderResponse readOrder(OrderRequest request) {
        MyOrder order = logic.fetchOrder(request.getId());

        OrderResponse response = new OrderResponse();
        return response;
    }
}
