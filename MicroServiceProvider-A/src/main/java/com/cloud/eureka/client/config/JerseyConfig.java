package com.cloud.eureka.client.config;

import java.util.TimeZone;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Component
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		JodaMapper jodaMapper = new JodaMapper();
		jodaMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		jodaMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		provider.setMapper(jodaMapper);
		register(provider);
		packages("com.cloud.eureka.client.resource");
		register(RequestContextFilter.class);
		register(LoggingFeature.class);
	}
}
