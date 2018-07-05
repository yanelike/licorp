package mx.com.licorp.business;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.com.licorp.dao.EventDao;
import mx.com.licorp.dao.EventProducer;
import mx.com.licorp.entity.EventBean;

@Component
public class EventBOImpl implements EventBO{
	
	@Autowired
	EventDao eventDAO;
	
	@Autowired
	private EventProducer eventMessage;
	
	@Override
	public void create(EventBean event) throws AmqpException, JsonProcessingException {
		eventDAO.create(event);
		eventMessage.sendEventMessage(event);
	}

}
