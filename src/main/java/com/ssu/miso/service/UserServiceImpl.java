package com.ssu.miso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssu.miso.persistence.UserMapper;
import com.ssu.miso.vo.MemberVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MemberVO login(String userid, String userpwd) throws Exception {
		MemberVO user = userMapper.login(userid);
		if (user == null) {
			return null;
		} else if (user.getPassword().equals(userpwd)) {
			return user;
		} else {
			return null;
		}
	}

}
