// package pos.pdwm.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {
    
//     @SuppressWarnings("removal")
//     @Bean
// 	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
// 			.csrf(csrf -> csrf
// 					.disable())
// 			.authorizeHttpRequests()
//             .requestMatchers("/css/**","/scripts/**").permitAll()
// 			.requestMatchers("/login?formAction=cadastralogin").permitAll()
// 			.requestMatchers("/login?error").permitAll() //ant seria mais apropriado, verificar o authorizeHttpRequests que esta "obsoleto"
// 			.requestMatchers(HttpMethod.OPTIONS).permitAll()
// 			.anyRequest()
// 			.authenticated()
// 			.and()
// 			.formLogin((form) -> form
// 							.loginPage("/login")
// 							.defaultSuccessUrl("/users", true)
// 							.permitAll()
// 			)
// 			.logout((logout) -> logout.permitAll());

// 		return http.build();
// 	}	
    
// }
