package net.yesdoing.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.yesdoing.domain.Question;
import net.yesdoing.domain.QuestionRepository;
import net.yesdoing.domain.User;

@Controller
@RequestMapping("/questions")
public class QuestionContoller {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/form")
	public String form(HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		return "qna/form";
	}
	
	@PostMapping("")
	public String create(Question question, HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		User user = HttpSessionUtils.getUserFromSession(session);
		question.setWriter(user.getUserId());
		questionRepository.save(question);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("question", questionRepository.findOne(id));
		return "qna/show";
	}
}
