package ch.frostnova.example.eureka.application.server.ws;

import ch.frostnova.example.eureka.application.server.ws.provider.CORSFilter;
import ch.frostnova.example.eureka.application.server.ws.provider.NoSuchElementExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * JAX-RS configuration
 */
@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(HelloEndpoint.class);
        register(CORSFilter.class);
        register(NoSuchElementExceptionMapper.class);
    }
}
