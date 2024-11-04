package video.store;

import java.util.Date;


public class Order {
    int id,
            customerId,
            total;
    String status;
    Date orderDate;
            
    public Order()
    {
    }
    public Order(int id,int customerId,int total,String status,Date orderDate){
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.status = status;
        this.orderDate = orderDate;
    }
    
}
