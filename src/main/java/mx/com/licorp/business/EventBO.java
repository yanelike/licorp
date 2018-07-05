package mx.com.licorp.business;

import org.springframework.amqp.AmqpException;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.com.licorp.entity.EventBean;

public interface EventBO {
	public void create(EventBean event) throws AmqpException, JsonProcessingException;
}
