package com.bugapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bugapp.model.Bug;
import com.bugapp.service.BugService;

@Controller
public class BugController {
	
	@Autowired
	private BugService<Bug> bugService;
	
//Get the Reporter form
	@GetMapping("/bugapp")
	public String home(Model model) {
		Bug bug = new Bug();
		
		model.addAttribute("bug", bug);
		
		return "bug_reporter";
	}
	
//	response to for the resolvers dash board
	@GetMapping("/bugapp/resolver")
	public String resolver(Model model) {
		
		Bug bug = new Bug();
		model.addAttribute("bug", bug);
		
		List<Bug> bug_list = bugService.list_all_bug();
		model.addAttribute("bug_list", bug_list);
		
		return "resolvers_dashboard";
	}
	
//	response for the reporter dash board
	@GetMapping("/bugapp/bug_details")
	public String bug_details(Model model) {
		
		Bug bug = new Bug();
		model.addAttribute("bug", bug);
		
		List<Bug> bug_list = bugService.list_all_bug();
		model.addAttribute("bug_list", bug_list);
		
		
		return "reporter_dashboard";
	}
	
//	save the reporter form data to the database 
	@PostMapping("/bugapp/bug_save")
	public String bug_details(@ModelAttribute("bug") Bug bug) {
		bugService.bug_save(bug);
		
		return "redirect:/bugapp/bug_details";
	}
	
	
	
//	save the resolver form data to the database 
	@PostMapping("/bugapp/resolver_bug_save")
	public String resolver_bug_details(@ModelAttribute("bug") Bug bug) {
		bugService.bug_save(bug);
		
		return "redirect:/bugapp/resolver";
	}
	
	
//	update the bug details for the reporter
	@GetMapping("/bugapp/bug_update/{id}")
	public ModelAndView edit_bug(@PathVariable(name="id") Long id) {
		
		ModelAndView model_view = new ModelAndView("bug_edit");
		ModelAndView model_view_new = new ModelAndView("bug_edit_new");
		
		Optional<Bug> bug = bugService.get_bug_by_id(id);
		if (bug.get().getStatus().equals("new")) {
			
			return model_view_new.addObject("bug", bug);
		}
		else {
			
			return model_view.addObject("bug", bug);
		}
				
	}
	
	
	
//	update the bug details from the resolver
	@GetMapping("/bugapp/resolver_bug_update/{id}")
	public ModelAndView resolver_edit_bug(@PathVariable(name="id") Long id) {
		ModelAndView model_view = new ModelAndView("resolver_bug_edit");
		
		
		Optional<Bug> bug = bugService.get_bug_by_id(id);
		model_view.addObject("bug", bug);
		
		return model_view;
	}
	
	
	
//	view the bug report without any permission to add delete and edit;
	@GetMapping("/bugapp/bug_view/{id}")
	public ModelAndView view_bug(@PathVariable(name="id") Long id) {
		ModelAndView view = new ModelAndView("bug_view");
		
		Optional<Bug> bug = bugService.get_bug_by_id(id);
		view.addObject("bug", bug);
		
		return view;
	}
	
	
	
//	view for the resolver
	@GetMapping("/bugapp/resolver_bug_view/{id}")
	public ModelAndView resolver_view_bug(@PathVariable(name="id") Long id) {
		ModelAndView view = new ModelAndView("resolver_bug_view");
		
		Optional<Bug> bug = bugService.get_bug_by_id(id);
		view.addObject("bug", bug);
		
		return view;
	}

//	to delete the data of the bug lists from the database
	@GetMapping("/bugapp/bug_delete/{id}")
	public String delete_bug(@PathVariable(name="id") Long id) {
		bugService.bug_delete(id);
		
		return "redirect:/bugapp/bug_details";
	}
	
}
