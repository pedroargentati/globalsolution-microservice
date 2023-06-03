package br.com.fiap.globalsolution.infra.security;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfigurations {
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		return http
//					.cors()
//					.and()
//					.csrf().disable()
//					.authorizeHttpRequests()
//					.requestMatchers(HttpMethod.GET, "/drones").permitAll()
//					.anyRequest()
//					.authenticated()
//					.and()
//					.build();
//
//	}
//	
//	/**
//	 * @description Ensina ao spring como injetar o objeto do tipo AuthenticationManager.
//	 * 
//	 * @param configuration
//	 * @throws Exception
//	 */
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}
//	
//	/**
//	 * @description Ensina ao spring que deverá usar o algoritmo 'BCryptPasswordEncoder'.
//	 */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDroneSeed = User.builder()
//                .username("userseed")
//                .password(passwordEncoder().encode("123"))
//                .roles("drone-seed")
//                .build();
//
//        UserDetails userDroneTelemetria = User.builder()
//                .username("usertele")
//                .password(passwordEncoder().encode("123"))
//                .roles("telemetria-reader")
//                .build();
//        
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("DRONE-ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDroneSeed, userDroneTelemetria, admin);
//    }
//
//}

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-security</artifactId>
//</dependency>