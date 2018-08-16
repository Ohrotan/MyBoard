package com.ssu.miso.service;

import java.util.List;

import com.ssu.miso.vo.CommentVO;

public interface CommentService {

	public List<CommentVO> list(Integer bno) throws Exception;

	public int create(CommentVO vo) throws Exception;

	public int update(CommentVO vo) throws Exception;

	public int remove(Integer rno) throws Exception;
}
