package com.ssu.miso.service;

import java.util.List;

import com.ssu.miso.vo.BoardVO;
import com.ssu.miso.vo.Criteria;
import com.ssu.miso.vo.SearchCriteria;

public interface BoardService {
	public void register(BoardVO board) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void modifyAll(BoardVO board) throws Exception;

	public void modify(BoardVO board) throws Exception;

	public void remove(Integer bno) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
