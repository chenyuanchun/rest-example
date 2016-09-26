package ca.nextpathway.midtier.callcentre;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class CallcentreConfiguration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CallcentreConfiguration.class);
		Properties defaultProperties = new Properties();
		defaultProperties.put("spring.config.name", "callcentre-rest");
//		defaultProperties.put("spring.profiles.active", "override");
		app.setDefaultProperties(defaultProperties);
		app.run(args);
	}
}
