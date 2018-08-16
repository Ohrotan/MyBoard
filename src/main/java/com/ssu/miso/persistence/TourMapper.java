package com.ssu.miso.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssu.miso.vo.TourVO;
import com.ssu.miso.vo.Criteria;
import com.ssu.miso.vo.SearchCriteria;

@Mapper
public interface TourMapper {
	public void create(TourVO vo) throws Exception;

	public TourVO read(Integer tno) throws Exception;

	public void delete(Integer tno) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<TourVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
