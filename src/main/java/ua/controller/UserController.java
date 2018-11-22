package ua.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Role;
import ua.entity.UserEntity;
import ua.servise.UserService;


@Controller
@SessionAttributes("user")
public class UserController {

	private final UserService service;
	

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@ModelAttribute("user")
	public UserEntity getForm(){
		return new UserEntity();
	}
	
	@GetMapping("/registration")
	public String registration(){
		return "registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user") UserEntity entity, SessionStatus status){
		entity.setRole(Role.ROLE_USER);
		service.save(entity);
		status.setComplete();
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	@GetMapping("/myinf")
	public String showPersonalInf( Model model , Principal principal){
		UserEntity entity = service.findByEmail(principal.getName());
		if(entity!=null) {
		model.addAttribute("user", entity);
		return "myInf";
		}
		return "index";
	}
	
	@PostMapping("/changepassword")
	public String chengePassword( @ModelAttribute("user") UserEntity user , Principal principal){
		
		UserEntity userEntity = service.findByEmail(principal.getName());
		userEntity.setPassword(user.getPassword());
		service.save(userEntity);
		System.out.println("PassChenged");
		return "index";
	}
	@GetMapping("/changepassword")
	public String chengePassword(){
				
		return "changepassword";
	}
	
	
	
	@GetMapping("/admin")
	public String showAllUsers(Model model){
		
		model.addAttribute("users", service.findAll());
		
		return "admin";
	}
	@GetMapping("/admin/userInf/{id}")
	public String showOneUsers(@PathVariable Integer id , Model model){
		
		UserEntity user = service.findOne(id);
		if(user!=null) {
			model.addAttribute("user", user);
			return "myInf";
		}
		
		return "admin";
	}
	
	
	
	
	@GetMapping("/admin/userInf/{id}/setadmin")
	public String setAdmin(@PathVariable Integer id){
		
		UserEntity userEntity = service.findOne(id);
		if (userEntity != null) {
			userEntity.setRole(Role.ROLE_ADMIN);
			service.update(userEntity);
			System.out.println(service.findOne(id).getEmail() + " adm now");
			
		}
		
		return "index";
	}
	
	@GetMapping("/admin/userInf/{id}/changepersinf")
	public String changePersInf(@PathVariable Integer id, Model model){
		
		model.addAttribute("user", service.findOne(id));
		
		return "changepersinf";
	}
	
	@PostMapping("/admin/userInf/{id}/changepersinf")
	public String changePersInf(@ModelAttribute ("user") UserEntity userEntity){
		
		UserEntity existUser = service.findOne(userEntity.getId());
		if (existUser != null) {
			existUser.setFirstName(userEntity.getFirstName());
			existUser.setSecondName(userEntity.getSecondName());
			service.update(existUser);
			
		}
		
		return "index";
	}
	
	@GetMapping("/admin/userInf/{id}/gotoexsel")
	public String createExsel(@PathVariable Integer id){
		
		service.createExsel(id);
		
		return "index";
	}
	
	
}
