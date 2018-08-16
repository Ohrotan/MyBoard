package com.ssu.miso.persistence;

import com.ssu.miso.vo.MemberVO;

public interface UserMapper {
	public MemberVO login(String id) throws Exception;
}
