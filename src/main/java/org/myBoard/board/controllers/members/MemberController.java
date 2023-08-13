package org.myBoard.board.controllers.members;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myBoard.board.models.member.MemberSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member/join")
@RequiredArgsConstructor
public class MemberController {
    private final MemberSaveService saveService;
    private final JoinValidator joinValidator;

    @GetMapping
    public String join(@ModelAttribute JoinForm joinForm, Model model) {



        return "member/join";
    }


    @PostMapping
    public String joinPs(@Valid JoinForm joinForm, Errors errors) {

        joinValidator.validate(joinForm, errors);

        if (errors.hasErrors()) {

            return "member/join";
        }

        saveService.save(joinForm);

        return "redirect:/member/login";
    }

}
