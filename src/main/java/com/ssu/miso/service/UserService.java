package com.ssu.miso.service;

import com.ssu.miso.vo.MemberVO;

public interface UserService {

	public MemberVO login(String id, String pwd) throws Exception;

}
