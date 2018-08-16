package com.ssu.miso.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssu.miso.vo.BoardVO;
import com.ssu.miso.vo.Criteria;
import com.ssu.miso.vo.SearchCriteria;

@Mapper
public interface BoardMapper {
	public void create(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void updateAll(BoardVO vo) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer bno) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
