package za.co.fynbos.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration  {

    @Bean  // the security configs not set properly
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.build();
    }

}
