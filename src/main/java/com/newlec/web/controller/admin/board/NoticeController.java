package com.newlec.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller(value = "adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {

	@Autowired
	private ServletContext ctx;

	@GetMapping("list")
	public String list() {

		return "admin.board.notice.list";
	}

	@PostMapping("reg")
	@ResponseBody
	public String reg(String content, String title, int cat, MultipartFile[] files)
			throws IllegalStateException, IOException {

		String webPath = "/static/upload";
		for (MultipartFile file : files) {
			String realPath = ctx.getRealPath(webPath);
			System.out.println(realPath);
			File savePath = new File(realPath);
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			realPath += File.separator + file.getOriginalFilename();
			File saveFile = new File(realPath);
			file.transferTo(saveFile);

		}
		return String.format("title : %s, content : %s, category : %d", title, content, cat);
	}

	@GetMapping("reg")
	public String reg() {
		return "admin.board.notice.reg";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "admin.board.notice.detail";
	}
	
	@RequestMapping("edit")
	public String edit() {

		return "";
	}

	@RequestMapping("del")
	public String del() {

		return "";
	}
}
