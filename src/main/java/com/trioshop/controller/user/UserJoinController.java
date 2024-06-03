package com.trioshop.controller.user;

import com.trioshop.SessionConst;
import com.trioshop.model.dto.user.GuestUserJoin;
import com.trioshop.model.dto.user.GuestUserJoin2;
import com.trioshop.model.dto.user.UserInfoBySession;
import com.trioshop.model.dto.user.UserJoin;
import com.trioshop.service.user.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
public class UserJoinController {
    private final HttpSession session;
    private final UserInfoService userInfoService;
    //@ModelAttribute 객체로 반환 UserJoin객체를 userJoin 라는 이름으로 가져온것임
    @GetMapping("/join")
    public String joinPage_G(@ModelAttribute("userJoin") UserJoin userJoin) {
        return "/user/userInfo/join";
    }

    @PostMapping("/join")
    public ModelAndView joinPage(@ModelAttribute("userJoin") UserJoin userJoin) {
        ModelAndView mv = new ModelAndView();
        try {
            boolean isRegistered = userInfoService.saveUserInfo(userJoin);
            if (isRegistered) {
                mv.setViewName("redirect:/login");
                mv.addObject("success", "회원가입에 성공했습니다.");
            } else {
                mv.setViewName("redirect:/join");
                mv.addObject("error", "이미 사용중인 계정입니다.");
            }
        } catch (Exception e) {
            mv.setViewName("redirect:/join");
            mv.addObject("exception", "회원가입 중 오류가 발생했습니다.");
        }
        return mv;
    }
    //@ModelAttribute 폼에서입력하면 컨트롤러로 전달~~
    @GetMapping("/guestLogin")
    public String guestLoginPage() {
        return "/user/userInfo/guestLogin";
    }

    @PostMapping("/guestLogin")
    public ModelAndView guestLogin(@ModelAttribute GuestUserJoin guestUserJoin, @ModelAttribute GuestUserJoin2 guestUserJoin2) {
        ModelAndView mv = new ModelAndView();

        // 첫 번째 로그인 시도
        GuestUserJoin existingUser = userInfoService.LoginGuestUser(guestUserJoin);

        // 기존 사용자가 있고 grade_code가 0인 경우에만 로그인 성공
        if (existingUser != null && existingUser.getGradeCode() == 0) {
            mv.setViewName("redirect:/");
        } else {
            // guestUserJoin 객체에 필요한 값 설정
            guestUserJoin.setGradeCode(0); // 예시로 gradeCode를 설정하고, 필요한 다른 값들도 설정해야 함

            // 중복된 DB가 없으면 회원가입을 시도
            boolean isSuccess = userInfoService.saveGuestUser(guestUserJoin, guestUserJoin2);
            if (isSuccess) {
                // 회원가입이 완료되면 자동으로 로그인
                mv.addObject("message", "회원가입이 완료되었습니다. 로그인되었습니다.");
            } else {
                mv.addObject("message", "로그인에 실패했습니다. 다시 시도해주세요.");
            }
            mv.setViewName("redirect:/");
        }
        // 나중에 수정해야할 부분
        UserInfoBySession sessionUser = new UserInfoBySession();
        sessionUser.setUserNickname("게스트유저");
        sessionUser.setUserCode(guestUserJoin.getUserCode());
        sessionUser.setGradeCode(1);
        session.setAttribute(SessionConst.LOGIN_MEMBER, sessionUser);
        ////수정
        return mv;
    }
}
