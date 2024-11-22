package Dita.Library.Controller;

import Dita.Library.DTO.LoginDto;
import Dita.Library.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class UsersController {

    @Autowired
    private UsersService usersService;

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
            // 로그인 성공 -> 메인 페이지로 리다이렉트
            return "redirect:login/registerUI";
        } else {
            // 로그인 실패 -> 에러 메시지와 함께 로그인 페이지로 이동
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "login/loginUI";
        }

    }
}
