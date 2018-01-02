package net.yesdoing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.yesdoing.domain.QuestionRepository;


@Controller
public class WelcomeController {
	
	@Autowired
	QuestionRepository questionRepository;

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "index";
	}
}
