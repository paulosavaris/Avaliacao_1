package pos.pdwm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
			.csrf(csrf -> csrf
					.disable())
			.authorizeHttpRequests()
                        .requestMatchers("/css/**", "/scripts/**").permitAll()
			.requestMatchers(HttpMethod.OPTIONS).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin((form) -> form
							.loginPage("/login")
							.defaultSuccessUrl("/users", true)
							.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}	

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("paulo.savaris")
            .password(encoder.encode("admin"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

}
