package com.demo.bootstrap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.bootstrap.DemoBootApplication;
import com.demo.bootstrap.domain.UserInfo;
import com.demo.bootstrap.service.BusinessService;

@Controller
@RequestMapping("/")
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(DemoBootApplication.class);
	
	@Autowired private BusinessService businessService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        String str = "Hello World!";
        mav.addObject("message", str);
        return mav;
    }
    
    @RequestMapping("/saveUser")
    public @ResponseBody void saveUser(UserInfo user) {
        this.businessService.saveUser(user);
    }
    
    @RequestMapping("/findOneUserByQueryDsl")
    public @ResponseBody UserInfo findOneUserByQueryDsl(UserInfo user) throws Exception{
    	return this.businessService.findOneUserByQueryDsl(user.getId());
    }
    
    @RequestMapping("/findListWithPagination")
    public @ResponseBody List<UserInfo> findListWithPagination(UserInfo user, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize")int pageSize) throws Exception{
    	Pageable pageRequest = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "id");
    	return this.businessService.findListWithPagination(user, pageRequest);
    }
}