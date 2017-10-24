package com.slz.cn.enrollandlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class EnrollandloginApplication {
 	List<Map<String,Object>> list = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(EnrollandloginApplication.class, args);
	}

	@RequestMapping("first")
	public String first(){
		return "enroll";
	}

	@RequestMapping("enroll")
	@ResponseBody
	public ModelAndView enroll(String acc,String pwd){
		ModelAndView modelAndView = new ModelAndView("login");
		Map<String,Object> person = new HashMap<>();
		person.put("acc",acc);
		person.put("pwd",pwd);
		list.add(person);
		return modelAndView;
	}

	@RequestMapping("login")
	@ResponseBody
	public ModelAndView login (String acc,String pwd){
		ModelAndView modelAndView = new ModelAndView("success");
		if(acc.equals("")){
			modelAndView.addObject("list",list);
		}else{
			for (int i = 0; i <list.size() ; i++) {
				if(acc.equals(list.get(i).get("acc"))&&pwd.equals(list.get(i).get("pwd"))){

					List<Map<String,Object>> lmap = new ArrayList<>();
					Map<String,Object> person = new HashMap<>();
					person.put("acc",acc);
					person.put("pwd",pwd);
					lmap.add(person);
					modelAndView.addObject("list",lmap);
				}
			}
		}

		return modelAndView;
	}

	@RequestMapping("select")
	@ResponseBody
	public ModelAndView select(String acc){
		ModelAndView modelAndView = new ModelAndView("success");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get(acc)!=null){
				modelAndView.addObject("people",list.get(i));
				break;
			}
		}
		return modelAndView;
	}
}
