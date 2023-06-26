package ClientManager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
    @Bean
    protected InMemoryUserDetailsManager configAuthentication() {
        List<UserDetails> users = new ArrayList<>();
        List<GrantedAuthority> adminAuthority = new ArrayList<>();

        adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails admin = new User("admin", "{noop}root", adminAuthority);
        users.add(admin);

        List<GrantedAuthority> userAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("USER"));
        UserDetails user = new User("user", "{noop}user", userAuthority);
        users.add(user);
        return new InMemoryUserDetailsManager(users);
    }*/

    @Autowired
    private UserDetailsService userDetailsService;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/editPerson/**", "/addPerson/**", "/deletePerson", "/savePerson").hasAuthority("ADMIN")
                .anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage("/errors/403")
                .and()
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                );
        return http.build();
    }
}