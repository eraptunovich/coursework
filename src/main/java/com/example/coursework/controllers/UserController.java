package com.example.coursework.controllers;

import com.example.coursework.models.User;
import com.example.coursework.models.enums.Role;
import com.example.coursework.repositories.UserRepository;
import com.example.coursework.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("/login")
//    public String loginPost(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
//        System.out.println("kkjskkdkcm");
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            System.out.println(authentication.getAuthorities());
//            // Логика успешного входа
//            return "redirect:/";
//        } catch (AuthenticationException e) {
//            // Логика неудачной попытки входа
//            return "redirect:/login?error";
//        }
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("role", Role.values());
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult result,
                             RedirectAttributes redirectAttributes,
                             @RequestParam("role") Role paramValue) {

        if (!userService.createUser(user)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Пользователь с таким логином уже существует! Выберите другой логин.");
            return "redirect:/registration";
        }


        userService.createUser(user);
        return "redirect:/login";
    }


    //чисто проверка как секьюрити работает
    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

    @GetMapping("/profile/{id}")
    public String userInfo(@PathVariable Long id, Model model) {

        User user = userService.getUserById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        model.addAttribute("issues", user.getIssues());
        return "profile";
    }


}
