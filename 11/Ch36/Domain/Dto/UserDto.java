package Ch36.Domain.Dto;
// Dto는 단순한 저장단위
// UserDto 생성 -> UserDao 생성 -> Main 에서 실행 -> ServiceImpl 생성 -> main 에서 실행 -> UserController 생성 및 정의 -> Main 에서 실행
public class UserDto {
	private String username;
	private String password;
	private String role;
	private boolean islocked;		// 계정 활성화 여부 (잠김 : true , 정상 : false)
	
	public UserDto() {}
	public UserDto(String username, String password, String role, boolean islocked) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.islocked = islocked;
	}
	
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", role=" + role + ", islocked=" + islocked
				+ "]";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isIslocked() {
		return islocked;
	}
	public void setIslocked(boolean islocked) {
		this.islocked = islocked;
	}
	
}
