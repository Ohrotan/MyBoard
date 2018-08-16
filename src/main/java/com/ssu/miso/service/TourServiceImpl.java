package com.ssu.miso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssu.miso.persistence.TourMapper;
import com.ssu.miso.vo.TourVO;
import com.ssu.miso.vo.Criteria;
import com.ssu.miso.vo.SearchCriteria;

@Service
public class TourServiceImpl implements TourService {
	@Autowired
	private TourMapper TourMapper;

	@Override
	public void register(TourVO vo) throws Exception {
		TourMapper.create(vo);
	}

	@Override
	public TourVO read(Integer tno) throws Exception {
		return TourMapper.read(tno);
	}


	@Override
	public void remove(Integer tno) throws Exception {
		TourMapper.delete(tno);

	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return TourMapper.countPaging(cri);
	}

	@Override
	public List<TourVO> listSearch(SearchCriteria cri) throws Exception {
		return TourMapper.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return TourMapper.listSearchCount(cri);
	}

}
