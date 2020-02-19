

@EnableWebSecurity
class SecurityConfig(@Autowired private val accountService: AccountService,
                     @Autowired private val passwordEncoder: PasswordEncoder): WebSecurityConfigurerAdapter() {

    companion object {
        const val LOGIN_SUCCESS_URL: String = "/view/success"
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(accountService)
            .passwordEncoder(passwordEncoder)
    }

    override fun configure(http: HttpSecurity) {
        http.anonymous()
                .and()
            .formLogin()
                .successForwardUrl(LOGIN_SUCCESS_URL)
                .and()
            .authorizeRequests()
                .anyRequest().authenticated()
    }

    @Bean
    fun bCryptPasswordEncoder() : BCryptPasswordEncoder = BCryptPasswordEncoder()
}


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ZerockUsersService zerockUsersService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		log.info("security config..............");

		http.authorizeRequests().antMatchers("/guest/**").permitAll();
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");

		http.formLogin().loginPage("/login");
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
		http.logout().invalidateHttpSession(true);
		
		http.userDetailsService(zerockUsersService);

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		log.info("build Auth global........");

		auth.userDetailsService(zerockUsersService).
		   passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

//		return new PasswordEncoder() {
//
//			@Override
//			public String encode(CharSequence rawPassword) {
//
//				return rawPassword.toString();
//			}
//
//			@Override
//			public boolean matches(CharSequence rawPassword, String encodedPassword) {
//
//				log.info("matches:" + rawPassword + ":" + encodedPassword);
//				return rawPassword.equals(encodedPassword);
//			}
//
//		};
		
		return new BCryptPasswordEncoder();

	}

}
