package mx.com.licorp.dao;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.com.licorp.entity.EventBean;

@Repository
public class EventDaoImpl implements EventDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	
	@Override
	public void create(EventBean event) throws AmqpException, JsonProcessingException {
		mongoTemplate.save(event);
	}

}
