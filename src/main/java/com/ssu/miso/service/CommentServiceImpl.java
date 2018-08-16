package com.ssu.miso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssu.miso.persistence.CommentMapper;
import com.ssu.miso.vo.CommentVO;

@Repository
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<CommentVO> list(Integer bno) throws Exception {
		return commentMapper.list(bno);
	}

	@Override
	public int create(CommentVO vo) throws Exception {
		return commentMapper.create(vo);
	}

	@Override
	public int update(CommentVO vo) throws Exception {
		return commentMapper.update(vo);
	}

	@Override
	public int remove(Integer rno) throws Exception {
		return commentMapper.remove(rno);
	}

}
