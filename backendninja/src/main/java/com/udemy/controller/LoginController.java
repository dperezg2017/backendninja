package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
// se elimina por la implementacion del spring security	
//	@GetMapping("/")
//	public String redirectTologin() {
//		LOG.info("METHOD: redirectTologin()");
//				return "redirect:/login";
//	}
	
	@GetMapping("/login")
	public String showLoginForm( Model model,
			@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout",required=false) String logout){
		LOG.info("METHOD: showLoginForm() -- PARAMS: error="+error+" , logout: "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
//		model.addAttribute("userCredentials", new UserCredential());
		LOG.info("Returning to login view");
				return ViewConstant.LOGIN;
	}
	@GetMapping({"/loginsuccess","/"}) // cuando pones llave , puede ir a cualquiera de esas URL que se coloca dentro
	public String loginCheck() {
		LOG.info("METHOD: loginCheck()");
		LOG.info("Redirect to login?error");
		return "redirect:/contacts/showcontacts";
	}
	
	
// se borra al implementar el SpringSecurity.
//	@PostMapping("/logincheck")
//	public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential) {
//		LOG.info("METHOD: loginCheck() --PARAMS: "+userCredential.toString());
//		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
//			LOG.info("Returning to contacts view");
//			return "redirect:/contacts/showcontacts";
//		}
//		LOG.info("Redirect to login?error");
//		return "redirect:/login?error";
//	}
}
