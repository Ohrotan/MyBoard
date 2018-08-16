package com.ssu.miso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssu.miso.persistence.BoardMapper;
import com.ssu.miso.vo.BoardVO;
import com.ssu.miso.vo.Criteria;
import com.ssu.miso.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void register(BoardVO board) throws Exception {
		boardMapper.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return boardMapper.read(bno);
	}

	@Override
	public void modifyAll(BoardVO board) throws Exception {
		boardMapper.updateAll(board);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardMapper.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardMapper.delete(bno);

	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return boardMapper.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return boardMapper.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return boardMapper.listSearchCount(cri);
	}

}
