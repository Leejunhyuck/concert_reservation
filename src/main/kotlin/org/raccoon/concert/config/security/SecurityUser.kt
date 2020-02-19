

class SecurityUser  (val user: User): User(
    val 
){

  override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = ArrayList<GrantedAuthority>()
        user.roles.map{ authorities.add(SimpleGrantedAuthority(it.name)) }

        return authorities
  }
  }



  	private static final String ROLE_PREFIX = "ROLE_";

	private Member member;

	public ZerockSecurityUser(Member member) {

		super(member.getUid(), member.getUpw(), makeGrantedAuthority(member.getRoles()));

		this.member = member;

	}

	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {

		List<GrantedAuthority> list = new ArrayList<>();

		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));

		return list;
	}