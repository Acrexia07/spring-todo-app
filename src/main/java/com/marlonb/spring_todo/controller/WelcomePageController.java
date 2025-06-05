package com.marlonb.spring_todo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomePageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayWelcomePage (ModelMap modelMap) {

        modelMap.put("name", getLoggedInUsername());

        return "welcome";
    }

    private String getLoggedInUsername() {

        var authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return authentication.getName();
    }
}
