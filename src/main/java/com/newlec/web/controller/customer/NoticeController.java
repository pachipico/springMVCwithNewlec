package com.newlec.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlec.web.entity.Notice;
import com.newlec.web.service.NoticeService;


@Controller
@RequestMapping("/customer/notice/*")
public class NoticeController {


	@Autowired
	private NoticeService noticeService;
	

	@GetMapping("/list")
	public String list (Model model) throws ClassNotFoundException, SQLException {
		List<Notice> list = noticeService.getList(1, "title", "");
		model.addAttribute("list", list);
		return "notice.list";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam("id") int id) {
		
		return "notice.detail";
	}

	
	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
}
