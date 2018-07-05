package mx.com.licorp.utils;


import org.springframework.context.annotation.Configuration;
 
@Configuration
public class RabbitConfig  
{
    public static final String QUEUE_ORDERS = "orders-queue";
    public static final String EXCHANGE_ORDERS = "orders-exchange";
}
