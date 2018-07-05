package mx.com.licorp.dao;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.licorp.entity.EventBean;
import mx.com.licorp.utils.RabbitConfig;

@Component
public class EventProducer {
	 	private final RabbitTemplate rabbitTemplate;
	    ObjectMapper mapper = new ObjectMapper();
	 
	    @Autowired
	    public EventProducer(RabbitTemplate rabbitTemplate) {
	        this.rabbitTemplate = rabbitTemplate;
	    }
	 
	    public void sendEventMessage(EventBean order) throws AmqpException, JsonProcessingException {
	        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS,mapper.writeValueAsString(order));

	    }
}
