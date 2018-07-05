package mx.com.licorp.utils;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.licorp.business.EventBO;
import mx.com.licorp.dao.EventDao;
import mx.com.licorp.entity.AspectReg;
import mx.com.licorp.entity.EventBean;
 
 

@Aspect
@Component
public class AspectBusiness {
	
	private static final Logger logger = Logger.getLogger(AspectBusiness.class.getName());
	
	@Autowired
	EventBO eventBO;

	@Before("execution(* mx.com.test.controller.*.*(..)) && @annotation(spanAnnotation)")
	public void before(final JoinPoint joinPoint, AspectReg spanAnnotation) throws Exception {
        
        Signature signature = joinPoint.getSignature();
        MethodSignature mSignature = (MethodSignature) signature;

        logger.info("-->RegistryAspect");
        EventBean event = new EventBean();
        event.setDateEvent(new Date());
        event.setName(mSignature.getName());
        eventBO.create(event);
	}
}
	