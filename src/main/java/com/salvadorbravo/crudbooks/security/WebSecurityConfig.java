package com.salvadorbravo.crudbooks.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(e -> e.disable())
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/api/v1/books/**").permitAll() // Permite acceso sin autenticación a los endpoints de libros
                                .anyRequest().authenticated()) // Cualquier otra ruta requiere autenticación
                .httpBasic(Customizer.withDefaults()) // Configura autenticación básica HTTP
                .build();
    }

    // Configuración de usuario en memoria para pruebas
    // Esta configuración es para propósitos de desarrollo y pruebas
    // En producción, deberías usar un UserDetailsService que obtenga los usuarios de una base de datos
    /*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}123") // {noop} indica que no se usará codificación de contraseña
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
     */
}
