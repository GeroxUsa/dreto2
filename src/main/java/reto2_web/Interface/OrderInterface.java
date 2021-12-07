package reto2_web.Interface;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto2_web.Model.Order;

import java.util.List;

public interface OrderInterface extends MongoRepository<Order, Integer> {

//    @Query("{id:?0}")
    @Query("{\"salesMan.zone\":?0}")
    public List<Order> getOrderByZone(String zone);

}
