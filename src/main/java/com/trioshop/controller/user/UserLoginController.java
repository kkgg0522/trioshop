package com.trioshop.controller.user;

import com.trioshop.SessionConst;
import com.trioshop.model.dto.user.UserInfoBySession;
import com.trioshop.model.dto.user.UserJoinModel;
import com.trioshop.service.user.UserLoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserLoginController {
    private final HttpSession session;

    @GetMapping("/login")
    public String loginPage(Model model) {
        String errorMessage = (String) session.getAttribute(SessionConst.ERROR_MESSAGE);
        if (errorMessage != null){
            model.addAttribute(SessionConst.ERROR_MESSAGE, errorMessage);
            session.removeAttribute(SessionConst.ERROR_MESSAGE);
        }
        return "/user/userInfo/login";

    }

//    //@ModelAttribute 객체를 받아오는거 @RequestParam 변수명을 가져오는거
//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute UserJoinModel loginModel) {
//        UserInfoBySession user = userLoginService.isValidUser(loginModel);
//        String redirectURI="/";
//
//        session.setAttribute(SessionConst.LOGIN_MEMBER, user);
//        //스프링이 자동으로 관리하는 세션 객체에 속성이 설정됩니다. 이렇게 하면 사용자가 로그인한 정보를 세션에 저장할 수 있습니다.
//        if (user.getGradeCode() == 4) {
//            redirectURI = "/trioAdmin";
//        }
//        return "redirect:"+redirectURI;
//    }


//    @GetMapping("/logout")
//    public String logoutPage(HttpSession session) {
//        session.invalidate();
//        return "redirect:/";
//    }
}
