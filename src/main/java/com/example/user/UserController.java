package com.example.user;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired private  UserService service;
    @Autowired private ExpenseRepository repo2;
    @Autowired private CatRepository repo3;

    @GetMapping("/users")
    public String showUserList(Model model) {
        System.out.println("gffvjgvjgv");
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
       return "user_form";
    }
    @RequestMapping("/login")
    public String showLoginPage(){
        System.out.println("Hello world");
        return "login";
    }

    @PostMapping(value = "/validateLogin1111")
    public String after_register(@RequestBody Map<String, String> model)
    {
        String returnPage;

        String usnm = model.get("email");
        String pass = model.get("password");
    System.out.println(usnm+"  "+pass);
        try {
            User user = service.getUserByUserName(usnm);
            if(null != user)
                returnPage = "form";
            else
                returnPage = "error";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return returnPage;
    }

    @PostMapping("/form")
    public String after_login()
    {
        return "form";
    }
    @RequestMapping("/expense_form")
    public String new_expense() {

        System.out.println("expense");
        return "expense_form";
    }
    @RequestMapping("/cat_form")
    public String new_category() {

        System.out.println("category");
        return "cat_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        service.save(user);
        ra.addFlashAttribute("message","New user saved successfully");
        return "redirect:/users";
    }
    @PostMapping("/expense_dtls")
    public String exp_add(@ModelAttribute Expense expense)
    {
        System.out.println(expense);
        repo2.save(expense);
        return "/expense_form";
    }
    @PostMapping("/cat_dtls")
    public String cat_add(@ModelAttribute Category category)
    {
        System.out.println(category);
        repo3.save(category);
        return "/cat_form";
    }
    @PostMapping("/to_form")
    public String goToForm()
    {
        return "form";
    }
    /*
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes ra){
        try {
            User user = service.get(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit User(ID:" + id + ")");
            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/users";
        }
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The user id " + id + " has been deleted successfully" );
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/users";
    } */

}
