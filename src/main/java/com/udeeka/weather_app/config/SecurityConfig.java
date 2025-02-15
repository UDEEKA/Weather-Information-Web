package com.udeeka.weather_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuerUri;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/api/weather").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/weather/all").authenticated() // Protect API
//                        .anyRequest().permitAll() // Allow other requests
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
//
//        return http.build();
//    }
//
//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        return converter;
//    }

        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Disable authentication for all endpoints
                )
                .csrf(AbstractHttpConfigurer::disable); // Disable CSRF for testing

        return http.build();

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(cors -> cors.configurationSource(request -> {
//                    var corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
//                    corsConfiguration.addAllowedOrigin("http://localhost:5173"); // ✅ Allow frontend
//                    corsConfiguration.addAllowedMethod("*"); // ✅ Allow all HTTP methods
//                    corsConfiguration.addAllowedHeader("*"); // ✅ Allow all headers
//                    corsConfiguration.setAllowCredentials(true);
//                    return corsConfiguration;
//                }))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/weather/all").authenticated() // Protect API
//                        .anyRequest().permitAll() // Allow other requests
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
//
//        return http.build();
//    }
//
//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        return new JwtAuthenticationConverter();
//    }
}
}

