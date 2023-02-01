package com.bankingApp.demo.controller;


import com.bankingApp.demo.model.AccountModel;
import com.bankingApp.demo.model.AddressModel;
import com.bankingApp.demo.model.LoanModel;
import com.bankingApp.demo.model.UserModel;
import com.bankingApp.demo.repository.AddressRepository;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Autowired
    AccountService accountService;

    @Autowired
    LoanService loanService;

    private static final String loanStatus1 = "processing";

    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
    public ModelAndView userDashBoard(Principal principal) {
        UserModel userModel = userService.findByUserName(principal.getName());
        return new ModelAndView("userDashBoard", "user", userModel);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView userProfile(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("userProfile");
        UserModel userModel = userService.get(userId);
        List<AddressModel> addressModelList = addressService.findAddressModels(userId);
        mv.addObject("user", userModel);
        mv.addObject("addressModels", addressModelList);
        return mv;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editProfile(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("userInfoEdit");
        UserModel userModel = userService.get(userId);
        mv.addObject("user", userModel);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(UserModel userModel, @RequestParam int userId, Model model) {
        userModel.setActive(true);
        userModel.setRole("ROLE_USER");
        userService.save(userModel);
        model.addAttribute("user", userModel);
        return "userDashBoard";
    }

    @RequestMapping(value = "/addressEdit", method = RequestMethod.GET)
    public ModelAndView editAddress(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("addressEdit");
        AddressModel addressModel = addressService.get(id);
        UserModel userModel = addressModel.getUser();
        mv.addObject("address", addressModel);
        mv.addObject("user", userModel);
        return mv;
    }

    @RequestMapping(value = "/newAddress", method = RequestMethod.GET)
    public ModelAndView addAddress(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("addressEdit");
        AddressModel addressModel = new AddressModel();
        UserModel userModel = userService.get(userId);
        mv.addObject("address", addressModel);
        mv.addObject("user", userModel);
        return mv;
    }

    @RequestMapping(value = "/addressSave", method = RequestMethod.POST)
    public ModelAndView saveAddress(AddressModel addressModel, @RequestParam int addressId, @RequestParam int userId, Principal principal) {
        ModelAndView mv = new ModelAndView("userDashBoard");
        addressModel.setAddressId(addressId);
        UserModel userModel = userService.get(userId);
        addressModel.setUser(userModel);
        addressService.save(addressModel);
        List<AddressModel> addressModelList = new ArrayList<>();
        addressModelList.add(addressModel);
        userModel.setAddressModelList(addressModelList);
        userService.save(userModel);
        mv.addObject("user", userService.findByUserName(principal.getName()));
        return mv;
    }

    @RequestMapping(value = "/genAccNo", method = RequestMethod.GET)
    public ModelAndView createAccount(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("newAccountForm");
        UserModel userModel = userService.get(userId);
        AccountModel accountModel = new AccountModel();
        accountModel.setBankName("Mahindra Bank");
        accountModel.setBranch("Trivandrum");
        accountModel.setUser(userModel);
        accountService.save(accountModel);
        mv.addObject("user", userModel);
        mv.addObject("account", accountModel);
        return mv;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submit(AccountModel accountModel, @RequestParam int userId, @RequestParam int accId) {
        ModelAndView mv = new ModelAndView("success");
        UserModel userModel = userService.get(userId);
        accountModel.setAccountId(accId);
        accountModel.setUser(userModel);
        accountService.save(accountModel);
        Set<AccountModel> accountModelList = userModel.getAccountModelList();
        accountModelList.add(accountModel);
        userModel.setAccountModelList(accountModelList);
        userService.save(userModel);
        return mv;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id, @RequestParam int userId, Model model) {
        addressService.delete(id);
        UserModel userModel = userService.get(userId);
        model.addAttribute("user", userModel);
        return "userProfile";
    }

    @RequestMapping(value = "/accountList", method = RequestMethod.GET)
    public ModelAndView showUserAccList(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("accountList");
        UserModel userModel = userService.get(userId);
        Set<AccountModel> accountModelSet = accountService.getActiveAccountDetails(userId);
        mv.addObject("user", userModel);
        mv.addObject("accountModelList", accountModelSet);
        return mv;
    }

    @RequestMapping(value = "/depositForm", method = RequestMethod.GET)
    public ModelAndView showDepositForm(@RequestParam int userId, @RequestParam int accId, Model model) {
        ModelAndView mv = new ModelAndView("depositForm");
        UserModel userModel = userService.get(userId);
        AccountModel accountModel = accountService.get(accId);
        mv.addObject("user", userModel);
        mv.addObject("account", accountModel);
        return mv;
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String deposit(AccountModel accountModel, @RequestParam int userId, @RequestParam int accId, @RequestParam String depositAmount, Model model) {
        UserModel userModel = userService.get(userId);
        accountModel.setBalanceAmount(accountModel.getBalanceAmount() + Float.parseFloat(depositAmount));
        accountModel.setAccountId(accId);
        accountModel.setUser(userModel);
        accountService.save(accountModel);
        Set<AccountModel> accountModelSet = new HashSet<>();
        accountModelSet.add(accountModel);
        userModel.setAccountModelList(accountModelSet);
        userService.save(userModel);
        model.addAttribute("message", "An amount of INR " + depositAmount + " has been Deposited into your account");
        return "success";
    }

    @RequestMapping(value = "/withdrawFrom", method = RequestMethod.GET)
    public ModelAndView showWithdrawalForm(@RequestParam int userId, @RequestParam int accId) {
        ModelAndView mv = new ModelAndView("withdrawForm");
        UserModel userModel = userService.get(userId);
        AccountModel accountModel = accountService.get(accId);
        mv.addObject("user", userModel);
        mv.addObject("account", accountModel);
        return mv;
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdraw(AccountModel accountModel, @RequestParam int userId, @RequestParam int accId, @RequestParam String withdrawalAmount, Model model) {
        UserModel userModel = userService.get(userId);
        accountModel.setBalanceAmount(accountModel.getBalanceAmount() - Float.parseFloat(withdrawalAmount));
        accountModel.setAccountId(accId);
        accountModel.setUser(userModel);
        accountService.save(accountModel);
        Set<AccountModel> accountModelSet = new HashSet<>();
        accountModelSet.add(accountModel);
        userModel.setAccountModelList(accountModelSet);
        userService.save(userModel);
        model.addAttribute("message", "An amount of INR " + withdrawalAmount + " has been Withdrawn from your account");
        return "success";
    }

    @RequestMapping(value = "/accountList2", method = RequestMethod.GET)
    public ModelAndView showUsrAccList(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("accountList");
        UserModel userModel = userService.get(userId);
        Set<AccountModel> accountModelSet = accountService.getActiveAccountDetails(userId);
        mv.addObject("loan", new LoanModel());
        mv.addObject("user", userModel);
        mv.addObject("accountModelList", accountModelSet);
        return mv;
    }

    @RequestMapping(value = "/loanReqForm", method = RequestMethod.GET)
    public ModelAndView loanReqForm(@RequestParam int userId, @RequestParam int accId) {
        ModelAndView mv = new ModelAndView("loanApplication");
        UserModel userModel = userService.get(userId);
        AccountModel accountModel = accountService.get(accId);
        LoanModel loanModel = new LoanModel();
        mv.addObject("loan", loanModel);
        mv.addObject("user", userModel);
        mv.addObject("account", accountModel);
        return mv;
    }

    @RequestMapping(value = "/loanSubmit", method = RequestMethod.POST)
    public String loanSubmit(LoanModel loanModel, @RequestParam int userId, @RequestParam int accId) {
        AccountModel accountModel = accountService.get(accId);
        loanModel.setUserId(userId);
        loanModel.setStatus(loanStatus1);
        loanModel.setAccountModel(accountModel);
        loanService.save(loanModel);
        List<LoanModel> loanModelList = new ArrayList<>();
        loanModelList.add(loanModel);
        accountModel.setLoanModelList(loanModelList);
        accountService.save(accountModel);
        return "success";
    }

    @RequestMapping(value = "/accountDetails", method = RequestMethod.GET)
    public ModelAndView showUserAccount(@RequestParam int userId) {
        ModelAndView mv = new ModelAndView("accountDetails");
        UserModel userModel = userService.get(userId);
        Set<AccountModel> accountModelSet = accountService.getActiveAccountDetails(userId);
        mv.addObject("user", userModel);
        mv.addObject("accountModelList", accountModelSet);
        return mv;
    }
}
