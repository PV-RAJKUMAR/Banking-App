package com.bankingApp.demo.controller;

import com.bankingApp.demo.model.AddressModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.repository.UserRepository;
import com.bankingApp.demo.service.AddressService;
import com.bankingApp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;


    @RequestMapping(value = "/showRegPage", method = RequestMethod.GET)
    public String regPage(Model model) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("address", new AddressModel());
        return "regPage";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") UserModel userModel, @ModelAttribute("address") AddressModel addressModel, Model model) {
        userModel.setActive(true);
        userModel.setRole("ROLE_USER");
        userService.save(userModel);
        addressModel.setUser(userModel);
        addressService.save(addressModel);
        List<AddressModel> addressModelList = new ArrayList<>();
        addressModelList.add(addressModel);
        userModel.setAddressModelList(addressModelList);
        userService.save(userModel);
        model.addAttribute("user", userModel);
        return "userDashBoard";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("403");
        return model;
    }

}
