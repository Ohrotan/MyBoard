package com.ssu.miso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssu.miso.service.CommentService;
import com.ssu.miso.vo.BoardVO;
import com.ssu.miso.vo.CommentVO;
import com.ssu.miso.vo.SearchCriteria;

@RequestMapping(value = "/comment")
@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private CommentService service;

	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<CommentVO>> list(@PathVariable("bno") Integer bno) {
		ResponseEntity<List<CommentVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.list(bno), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> write(@RequestBody CommentVO cmt, Model model, RedirectAttributes r) throws Exception {
		service.create(cmt);
		model.addAttribute("result", "success");
		r.addFlashAttribute("msg", "success");
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}

	@RequestMapping(value = "/update/{cno}", method = RequestMethod.GET)
	public ModelAndView updatePage(@PathVariable("cno") int cno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		ModelAndView mnv = new ModelAndView("read");
		// if (vo == null) {
		mnv.addObject("error", "wrong_bno");
		logger.info("vo is null...");
		// } else {
		// mnv.addObject("boardVO", vo);
		// }
		return mnv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO board, @RequestParam("visitdate") String visitdate, MultipartFile file,
			SearchCriteria cri, RedirectAttributes r) throws Exception {
		board.setVisitDate(visitdate);

		r.addAttribute("bno", board.getBno());
		r.addAttribute("page", cri.getPage());
		r.addAttribute("perPageNum", cri.getPerPageNum());
		r.addAttribute("searchType", cri.getSearchType());
		r.addAttribute("keyword", cri.getKeyword());
		r.addFlashAttribute("msg", "success");
		return "redirect:/read";
	}

	@RequestMapping(value = "/delete/{cno}", method = RequestMethod.GET)
	public void delete(@PathVariable("cno") int cno, SearchCriteria cri, RedirectAttributes r) throws Exception {
		service.remove(cno);
		r.addFlashAttribute("msg", "success");
	}
}
