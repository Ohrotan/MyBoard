package com.ssu.miso.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssu.miso.vo.CommentVO;

@Mapper
public interface CommentMapper {

	public List<CommentVO> list(Integer bno) throws Exception;

	public CommentVO search(Integer cno) throws Exception;

	public int create(CommentVO vo) throws Exception;

	public int update(CommentVO vo) throws Exception;

	public int remove(Integer bno) throws Exception;

}
