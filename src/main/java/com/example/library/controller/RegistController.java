package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistController {
	@RequestMapping("/regist")
	public String regist() {
		return "regist";
	}
}