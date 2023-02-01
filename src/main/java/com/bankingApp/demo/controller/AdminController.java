package com.bankingApp.demo.controller;

import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.AddressModel;
import com.bankingApp.demo.model.LoanModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.repository.AccountRepository;
import com.bankingApp.demo.repository.AddressRepository;
import com.bankingApp.demo.repository.LoanRepository;
import com.bankingApp.demo.service.AccountService;
import com.bankingApp.demo.service.AddressService;
import com.bankingApp.demo.service.LoanService;
import com.bankingApp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    AddressService addressService;

    @Autowired
    LoanService loanService;

    private static final String loanStatus1 = "processing";

    private static final String loanStatus2 = "approved";

    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
    public ModelAndView userDashBoard(Principal principal) {
        UserModel userModel = userService.findByUserName(principal.getName());
        return new ModelAndView("adminDashBoard", "user", userModel);
    }

    @RequestMapping(value = "/listForAccountNo", method = RequestMethod.GET)
    public ModelAndView listForAccNoAprvl() {
        ModelAndView mv = new ModelAndView("listForAccNoAprvl");
        Set<AccountModel> accountModelList = accountService.getInactiveAccountDetails();
        mv.addObject("accModelList", accountModelList);
        return mv;
    }

    @RequestMapping(value = "/assignAccNo", method = RequestMethod.GET)
    public ModelAndView assignAccNoForm(@RequestParam int accId) {
        ModelAndView mv = new ModelAndView("accountNoAssignForm");
        AccountModel accountModel = accountService.get(accId);
        UserModel userModel = accountModel.getUser();
        mv.addObject("user", userModel);
        mv.addObject("account", accountModel);
        return mv;
    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public String assign(AccountModel accountModel, @RequestParam int accId, @RequestParam int userId) {
        accountModel.setAccountId(accId);
        UserModel userModel = userService.get(userId);
        accountModel.setUser(userModel);
        accountService.save(accountModel);
        return "redirect:listForAccountNo";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String customersList(Model model) {
        List<UserModel> userModelList = accountService.getRegUserList();
        model.addAttribute("usersList", userModelList);
        return "regCustomersList";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView userProfile(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("userProfile1");
        UserModel userModel = userService.get(userId);
        List<AddressModel> addressModelList = addressService.findAddressModels(userId);
        mv.addObject("user", userModel);
        mv.addObject("addressModels", addressModelList);
        return mv;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newCustomer(Model model) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("address", new AddressModel());
        model.addAttribute("account", new AccountModel());
        return "adminSideRegPage";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(UserModel userModel, AddressModel addressModel, AccountModel accountModel, Model model) {
        userService.save(userModel);
        addressModel.setUser(userModel);
        addressService.save(addressModel);
        accountModel.setUser(userModel);
        accountService.save(accountModel);
        List<AddressModel> addressModelList = new ArrayList<>();
        addressModelList.add(addressModel);
        userModel.setAddressModelList(addressModelList);
        userService.save(userModel);
        Set<AccountModel> accountModelSet = new HashSet<>();
        accountModelSet.add(accountModel);
        userModel.setAccountModelList(accountModelSet);
        userService.save(userModel);
        return "redirect:new";
    }

    @RequestMapping(value = "/loanReqList", method = RequestMethod.GET)
    public String loanReqList(Model model) {
        List<LoanModel> loanModels = loanService.findByStatus(loanStatus1);
        model.addAttribute("loanModels", loanModels);
        return "loanReqList";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    public String approveLoan(@RequestParam int loanId) {
        LoanModel loanModel = loanService.get(loanId);
        loanModel.setStatus(loanStatus2);
        loanService.save(loanModel);
        AccountModel accountModel = loanModel.getAccountModel();
        accountModel.setBalanceAmount(accountModel.getBalanceAmount() + loanModel.getAmt_req());
        accountService.save(accountModel);
        return "redirect:loanReqList";
    }

    @RequestMapping(value = "/reject", method = RequestMethod.GET)
    public String rejectLoan(@RequestParam int loanId) {
        loanService.delete(loanId);
        return "redirect:loanReqList";
    }

    @RequestMapping(value = "/deleteAcc", method = RequestMethod.GET)
    public String deleteReq(@RequestParam int accId) {
        accountService.delete(accId);
        return "redirect:listForAccountNo";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchCus(@RequestParam String userId, Model model) {
        UserModel userModel = userService.findByUserId(Integer.parseInt(userId));
        List<AddressModel> addressModelList = addressService.findAddressModels(Integer.parseInt(userId));
        model.addAttribute("user", userModel);
        model.addAttribute("addressModels", addressModelList);
        return "userProfile1";
    }


}
