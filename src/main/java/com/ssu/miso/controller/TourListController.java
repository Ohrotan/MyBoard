package com.ssu.miso.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssu.miso.service.TourService;
import com.ssu.miso.vo.PageMaker;
import com.ssu.miso.vo.SearchCriteria;
import com.ssu.miso.vo.TourVO;

@Controller
public class TourListController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private TourService service;

	@RequestMapping(value = "/tourList", method = RequestMethod.GET)
	public void board(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());

		model.addAttribute("list", service.listSearch(cri));
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("pageMaker", pm);
	}

	@RequestMapping(value = "/reqTour", method = RequestMethod.POST)
	public String requestTour(TourVO tour, @RequestParam("visitdate") String visitdate, Model model,
			RedirectAttributes r) throws Exception {
		tour.setVisitdate(visitdate);
		service.register(tour);
		model.addAttribute("result", "success");
		r.addFlashAttribute("msg", "success");

		return "redirect:/";
	}

	@RequestMapping(value = "/tourDelete/{tno}", method = RequestMethod.GET)
	public String deleteTour(@PathVariable int tno, RedirectAttributes r) throws Exception {
		service.remove(tno);

		return "redirect:/tourList";
	}

}
