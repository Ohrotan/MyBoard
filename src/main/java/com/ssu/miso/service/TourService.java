package com.ssu.miso.service;

import java.util.List;

import com.ssu.miso.vo.TourVO;
import com.ssu.miso.vo.Criteria;
import com.ssu.miso.vo.SearchCriteria;

public interface TourService {
	public void register(TourVO vo) throws Exception;

	public TourVO read(Integer tno) throws Exception;

	public void remove(Integer tno) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<TourVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
