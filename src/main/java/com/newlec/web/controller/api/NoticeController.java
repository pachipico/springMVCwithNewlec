package com.newlec.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlec.web.entity.Notice;
import com.newlec.web.service.NoticeService;

@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public List<Notice> list() throws ClassNotFoundException, SQLException {
		List<Notice> list = noticeService.getList(1, "title", "");

		return list;

	}
}
