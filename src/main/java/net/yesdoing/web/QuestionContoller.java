package net.yesdoing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.yesdoing.domain.Question;
import net.yesdoing.domain.QuestionRepository;

@Controller
@RequestMapping("/questions")
public class QuestionContoller {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form() {
		return "qna/form";
	}
	
	@PostMapping("")
	public String create(Question question) {
		System.out.println("Question : " + question);
		questionRepository.save(question);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("question", questionRepository.findOne(id));
		return "qna/show";
	}
}
