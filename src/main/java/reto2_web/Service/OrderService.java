package reto2_web.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto2_web.Model.Order;
import reto2_web.Repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.create(order);
        }
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> accesoryDb = orderRepository.getOrder(order.getId());
            if (!accesoryDb.isEmpty()) {

                if (order.getRegisterDay()!= null) {
                    accesoryDb.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    accesoryDb.get().setStatus(order.getStatus());
                }

                if (order.getProducts() != null) {
                    accesoryDb.get().setProducts(order.getProducts());
                }
                if (order.getSalesMan() != null) {
                    accesoryDb.get().setSalesMan(order.getSalesMan());
                }
                if (order.getQuantities() != null) {
                    accesoryDb.get().setQuantities(order.getQuantities());
                }

                orderRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer reference) {
        Boolean aBoolean = getOrder(reference).map(accesory -> {
            orderRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }
}
