package Dita.Library.Controller;

import Dita.Library.DTO.LoginDto;
import Dita.Library.DTO.SignupDto;
import Dita.Library.Service.UsersService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/login")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }
    @GetMapping
    public String showLoginPage() {
        return "login"; // 로그인 화면 반환
    }

    @PostMapping("/logindo")
    public String login(@ModelAttribute LoginDto loginDto, Model model) {
        if (loginDto.getUser_id() == null || loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
            model.addAttribute("error", "아이디와 비밀번호를 모두 입력해주세요.");
            return "login/loginUI"; // 로그인 페이지로 이동
        }

        // 2. Service 호출
        boolean isValid = usersService.checklogin(loginDto);

        // 3. 결과 처리
        if (isValid) {
            // 로그인 성공 -> 메인 페이지로 리다이렉트(이지만 지금은 회원가입)
            return "redirect:registerUI.html";
        } else {
            // 로그인 실패 -> 에러 메시지와 함께 로그인 페이지로 이동
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "login/loginUI";
        }
    }

    @PostMapping("/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // 오류가 있으면 각 필드의 오류 메시지를 모델에 추가
            // BindingResult에서 오류 메시지 추출
            bindingResult.getAllErrors().forEach(error -> {
                model.addAttribute("error", error.getDefaultMessage());
            });

            // 입력한 데이터도 모델에 다시 추가하여 폼에 데이터가 남도록 처리
            model.addAttribute("signupDto", signupDto);

            return "login/registerUI";
        }

        // 2. Service 호출
        boolean isValid = usersService.registerUser(signupDto);

        // 3. 결과 처리
        if (isValid) {
            // 회원가입 성공 -> 로그인 페이지로 리다이렉트
            return "redirect:loginUI.html";
        } else {
            // 로그인 실패 -> 에러 메시지
            model.addAttribute("error", "이미 존재하는 아이디 입니다.");

            // 입력한 데이터도 모델에 다시 추가하여 폼에 데이터가 남도록 처리
            model.addAttribute("signupDto", signupDto);
            return "login/registerUI";
        }

    }
}
