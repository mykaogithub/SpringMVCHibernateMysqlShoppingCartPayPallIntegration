package com.kyanja.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyanja.model.Client;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		Client clientForm = new Client();
		model.put("clientForm", clientForm);

		List<String> professionList = new ArrayList<>();
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		model.put("professionList", professionList);

		return "Registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("clientForm") Client client, Map<String, Object> model) {

		// implement your own registration logic here...

		// for testing purpose:
		System.out.println("username: " + client.getUsername());
		System.out.println("password: " + client.getPassword());
		System.out.println("email: " + client.getEmail());
		System.out.println("birth date: " + client.getBirthDate());
		System.out.println("profession: " + client.getProfession());

		return "RegistrationSuccess";
	}
}