package architecture.CoursesWebApplication.CoursesManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CoursesWebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		
		
		// password "password" is externally encrypted to the following
		UserDetails user1 = User.withUsername("admin")
			     .password("$2a$12$HexDpMOzeB2.WJbRX9LP.O2JLGazurWK2c25et1ij7J6fYjKSzklm")
			     .roles("ADMIN")
			     .build();
		
		
		auth.inMemoryAuthentication().withUser(user1);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


}
