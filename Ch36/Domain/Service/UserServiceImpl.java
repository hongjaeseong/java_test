package Ch36.Domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Ch36.Domain.Dao.SessionDaoImpl;
import Ch36.Domain.Dao.UserDaoImpl;
import Ch36.Domain.Dto.SessionDto;
import Ch36.Domain.Dto.UserDto;

public class UserServiceImpl {
	// 내장 객체
	private List<Integer> SessionIdList;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDaoImpl userDao;
	private SessionDaoImpl sessionDao;
	
	public UserServiceImpl() throws Exception {
		System.out.println("UserServiceImpl's UserServiceImpl()");
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		userDao = new UserDaoImpl();
		sessionDao = new SessionDaoImpl();
		SessionIdList = new ArrayList();
	}
	
	// 회원가입
	public boolean UserJoin(UserDto dto) throws Exception {
		// 비즈니스 로직 (나중에 추가) (논의를 통해 결정된 사항)
		// 입력 패스워드 + re패스워드 일치 여부 (패스워드 확인)
		// 패스워드 정책 (정규 표현식)
		// 현재 상태가 로그인 된 상태인지 고려
		// ... 시퀀스 다이어그램 필요
		// 패스워드 암호화
		String encrypt = bCryptPasswordEncoder.encode(dto.getPassword());	// dto의 패스워드를 암호화
		dto.setPassword(encrypt);		// 암호화된 password를 다시 dto에 저장
		
		return userDao.Insert(dto);
	}
	
	// 로그인
	public Map<String,Object> login(String username,String password,int SessionId) throws Exception {
		Map<String,Object> result = new HashMap();
		
		// 1. SessionList에 동일한 세션정보가 있는 지 확인
		for(int id : SessionIdList) {
			if(SessionId == id)	{		// 로그인한 상태
				result.put("response", false);
				result.put("msg", "이미 해당 계정은 로그인한 상태입니다.");
				return result;
			}
		}
		
		// 2. 로그인된 상태가 아니라면 user 테이블로부터 동일한 이름의 user정보를 가져오기 (getUser())
		UserDto savedUser = getUser(username);
		if(savedUser == null) {
			result.put("response", false);
			result.put("msg", "동일 계정이 존재하지 않습니다.");
			return result;
		}
		
		// 3. PW 일치여부 확인
		if( !bCryptPasswordEncoder.matches( password, savedUser.getPassword() ) ) {
			result.put("response", false);
			result.put("msg", "패스워드가 일치하지 않습니다.");
			return result;		// 일치안한다면('!') 로그인 실패
		}
		
		// 4. PW 일치한다면 session 테이블에 세션정보 저장
		SessionDto sessionDto = new SessionDto();
		sessionDto.setUsername(savedUser.getUsername());
		sessionDto.setRole(savedUser.getRole());
		boolean isSessionSaved = sessionDao.Insert(sessionDto);
		if(isSessionSaved) {
			result.put("response", false);
			result.put("msg", "로그인 처리중 오류가 발생하였습니다. Session 생성 실패...");
			return result;		
		}
		
		// 5. PW 일치한다면 sessionList에 sessionId 값 저장
		Integer id = sessionDao.Select(sessionDto.getUsername()).getSessionId();
		result.put("response", true);
		result.put("msg", "로그인 성공!");
		SessionIdList.add(id);
		return result;
		// 동일한 세션정보도 없고 로그인한 상태도 아니고 pw도 일치한다면 세션 객체를 만들어서 db에 저장
		
	}
	// 로그아웃
	public boolean logout(int SessionId) {
		return false;
	}
	// 유저정보 가져오기
	public UserDto getUser(String username) throws Exception {
		return userDao.Select(username);
	}
	
	// 현재 접속중인 세션 Id list 리턴
	public List<Integer> getSessionIdList(){
		return SessionIdList;
	}
	
	
	
	
	
	
}
