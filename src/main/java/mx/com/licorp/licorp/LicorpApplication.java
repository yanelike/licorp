package mx.com.licorp.licorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({"mx.com.*"})
@EnableJpaRepositories("mx.com.licorp.dao")
@EntityScan("mx.com.licorp.entity")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		AopAutoConfiguration.class
} )
public class LicorpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicorpApplication.class, args);
	}
}
