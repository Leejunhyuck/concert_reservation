
@Service
class UserService(@Autowired private val userRepository: UserRepository): UserDetailsService
{
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
        user?: throw UsernameNotFoundException("cannot find such username: $username")

        return CustomUserDetails(user)
    }
}


	@Autowired
	MemberRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return  
			repo.findById(username)
			.filter(m -> m != null)
			.map(m -> new ZerockSecurityUser(m)).get();
		
	}