package com.ssu.miso.controller;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssu.miso.service.BoardService;
import com.ssu.miso.service.CommentService;
import com.ssu.miso.vo.BoardVO;
import com.ssu.miso.vo.PageMaker;
import com.ssu.miso.vo.SearchCriteria;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private BoardService service;
	@Inject
	private CommentService cmtservice;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public void board(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		model.addAttribute("list", service.listSearch(cri));
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.listSearchCount(cri));
		logger.info("tot cnt!!!!!!!!!!!!!!!!" + pm.getTotalCount());
		model.addAttribute("pageMaker", pm);
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writePage() {
		return "posting";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO board, @RequestParam("visitdate") String visitdate, MultipartFile file, Model model,
			RedirectAttributes r) throws Exception {
		board.setVisitDate(visitdate);

		if (file != null) {
			String newFilename = uploadFile(file.getOriginalFilename(), file.getBytes());
			board.setPic(newFilename);
			model.addAttribute("newFilename", newFilename);
			System.out.println("file..");
		}

		service.register(board);
		model.addAttribute("result", "success");
		r.addFlashAttribute("msg", "success");

		return "redirect:/board";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		logger.info("read board...");
		ModelAndView mnv = new ModelAndView("read");
		BoardVO vo = service.read(bno);
		mnv.addObject("clist", cmtservice.list(bno));
		if (vo == null) {
			// mnv.setViewName("/board/listAll");
			mnv.addObject("error", "wrong_bno");
			logger.info("vo is null...");
		} else {
			mnv.addObject("boardVO", vo);
		}
		return mnv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		ModelAndView mnv = new ModelAndView("update");
		BoardVO vo = service.read(bno);
		if (vo == null) {
			// mnv.setViewName("/board/listAll");
			mnv.addObject("error", "wrong_bno");
			logger.info("vo is null...");
		} else {
			mnv.addObject("boardVO", vo);
		}
		return mnv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO board, @RequestParam("visitdate") String visitdate, MultipartFile file,
			SearchCriteria cri, RedirectAttributes r) throws Exception {
		board.setVisitDate(visitdate);

		if (file != null) {
			String newFilename = uploadFile(file.getOriginalFilename(), file.getBytes());
			board.setPic(newFilename);
			System.out.println("file..");
			service.modifyAll(board);
		} else {
			service.modify(board);
		}

		r.addAttribute("bno", board.getBno());
		r.addAttribute("page", cri.getPage());
		r.addAttribute("perPageNum", cri.getPerPageNum());
		r.addAttribute("searchType", cri.getSearchType());
		r.addAttribute("keyword", cri.getKeyword());
		r.addFlashAttribute("msg", "success");
		return "redirect:/read";
	}

	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.GET)
	public String delete(@PathVariable("bno") int bno, SearchCriteria cri, RedirectAttributes r) throws Exception {
		service.remove(bno);
		r.addAttribute("page", cri.getPage());
		r.addAttribute("perPageNum", cri.getPerPageNum());
		r.addAttribute("searchType", cri.getSearchType());
		r.addAttribute("keyword", cri.getKeyword());
		r.addFlashAttribute("msg", "success");
		return "redirect:/board";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		String uploadPath = "c:/data/miso/img";
		String newFilename = getNewFilename(originalName);

		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs(); // 존재하지 않는 모든 폴더 생성
		}
		File target = new File(uploadPath, newFilename);
		FileCopyUtils.copy(fileData, target);
		return newFilename;
	}

	private String getNewFilename(String filename) {
		String ext = filename.substring(filename.indexOf('.'));
		return UUID.randomUUID().toString() + ext;
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			// MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			// in = new FileInputStream(uploadPath+fileName);
		} catch (Exception e) {
		}
		return entity;
	}
}
