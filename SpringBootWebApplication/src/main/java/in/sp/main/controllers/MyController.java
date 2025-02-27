package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	private UserServiceImpl userSer;

	@GetMapping("/regPage")
	public String openRegPage(Model model)
	{
		model.addAttribute("user",new User());
		return "register";	
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user,Model model)
	{
		boolean status = userSer.registerUser(user);
		if(status)
		{
			model.addAttribute("successMsg" ,"User registered successfully ");
			
		}
		else
		{
			model.addAttribute("errorMsg","something went wrong");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage( Model model)
	{
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String  submitLoginForm(@ModelAttribute("user") User user ,Model model)
	{
		User validUser =userSer.loginUser(user.getEmail(), user.getPassword());
		if(validUser!=null)
		{
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}
		else
		{
			model.addAttribute("errorMsg","Email id and password didnt matche");
			return "login";
		}
		
		
	
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest req)
	{
		HttpSession s=  req.getSession(false);
		if(s!=null)
		{
			s.invalidate();
		}
		return "login";
	}
	
}
