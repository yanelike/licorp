package mx.com.licorp.dao;

import org.springframework.amqp.AmqpException;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.com.licorp.entity.EventBean;

public interface EventDao {
	public void create(EventBean event) throws AmqpException, JsonProcessingException;
}
