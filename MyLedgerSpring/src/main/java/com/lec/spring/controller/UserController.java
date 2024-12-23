package com.lec.spring.controller;

import com.lec.spring.domain.User;
import com.lec.spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String registerOk(@Valid User user,
                             BindingResult result,
                             Model model,
                             RedirectAttributes redirectAttrs) {

        // 검증 에러가 있었다면 redirect 한다
        if (result.hasErrors()) {
//            redirectAttrs.addFlashAttribute("username", user.getUsername());
//            redirectAttrs.addFlashAttribute("name", user.getName());
//            redirectAttrs.addFlashAttribute("email", user.getEmail());
//
//            List<FieldError> errList = result.getFieldErrors();
//            for(FieldError err : errList) {
//                redirectAttrs.addFlashAttribute("error", err.getCode());  // 가장 처음에 발견된 에러를 담아ㅣ 보낸다
//                break;
//            }

            return "redirect:/user/register";
        }

        // 에러 없었으면 회원 등록 진행
        String page = "user/registerOk";
        int cnt = userService.register(user);
        model.addAttribute("result", cnt);
        return page;
    }

    @GetMapping("/login")
    public void login(){
    }

    @PostMapping("/loginError")
    public String loginError(){
        return "user/login";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        return ResponseEntity.ok(user);
    }

}
