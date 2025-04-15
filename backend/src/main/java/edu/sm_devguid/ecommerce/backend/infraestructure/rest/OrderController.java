package edu.sm_devguid.ecommerce.backend.infraestructure.rest;

import edu.sm_devguid.ecommerce.backend.application.OrderService;
import edu.sm_devguid.ecommerce.backend.domain.model.Order;
import edu.sm_devguid.ecommerce.backend.domain.model.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@Slf4j

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order){

        OrderState orderState = order.getOrderState().toString()
                .equals(OrderState.CANCELLED.toString()) ?
                OrderState.CANCELLED : OrderState.CONFIRMED;

        order.setOrderState(orderState);
        return ResponseEntity.ok(orderService.save(order));
    }

    @PostMapping("/update/state/order")
    public ResponseEntity<HttpStatus> updateStateById(@RequestParam Integer id, @RequestParam String state){
        orderService.updateStateById(id, state);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Iterable<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<Iterable<Order>> findByUserId(@PathVariable("id") Integer userId){
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }

}
