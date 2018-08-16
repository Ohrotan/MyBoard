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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssu.miso.service.BoardService;
import com.ssu.miso.service.CommentService;
import com.ssu.miso.vo.CommentVO;
import com.ssu.miso.vo.SearchCriteria;

@RequestMapping(value = "/comment")
@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private CommentService service;
	@Inject
	private BoardService boardservice;

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
	@ResponseBody
	public ModelAndView updatePage(@PathVariable("cno") int cno, Model model) throws Exception {
		CommentVO vo = service.search(cno);
		ModelAndView mnv = new ModelAndView("read");
		mnv.addObject("cmt", "update");
		if (vo == null) {

		} else {
			mnv.addObject("cmtVO", vo);
		}
		return mnv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> update(@RequestBody CommentVO cmt, RedirectAttributes r) throws Exception {
		service.update(cmt);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}

	@RequestMapping(value = "/delete/{cno}", method = RequestMethod.GET)
	public String delete(@PathVariable("cno") int cno, SearchCriteria cri, RedirectAttributes r) throws Exception {

		CommentVO vo = service.search(cno);
		service.remove(cno);
		r.addFlashAttribute("bno", vo.getBno());
		return "redirect:/read" ;
	}
}
