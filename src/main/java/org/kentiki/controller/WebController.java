package org.kentiki.controller;

import lombok.RequiredArgsConstructor;
import org.kentiki.dto.AnswerDto;
import org.kentiki.servise.FileService;
import org.kentiki.servise.ImgService;
import org.kentiki.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final ImgService imgService;
    private final FileService fileService;

    @GetMapping("/website")
    public String mainPage(){
        return "mainPage";
    }

    @GetMapping("/website/right")
    public String rightAnswerPage() {
        return "rightAnswerPage";
    }

    @GetMapping("/website/wrong/{imgName}")
    public String wrongAnswerPage(Model model, @PathVariable String imgName) {
        model.addAttribute("date", imgService.getByName(imgName).getDate());
        return "wrongAnswerPage";
    }

    @GetMapping("/website/quiz")
    public String quizPage() {
        return "redirect:/website/quiz/" + imgService.getRandomeImg().getName();
    }

    @GetMapping("/website/quiz/{imgName}")
    public String quizImgPage(Model model, @PathVariable String imgName) {
        model.addAttribute("action",  imgName);
        model.addAttribute("imgName", FileUtils.getFilePath(imgName));
        model.addAttribute("answer", new AnswerDto());
        return "quizPage";
    }

    @PostMapping("/website/quiz/{imgName}")
    public String checkAnswer(@ModelAttribute AnswerDto answerDto, @PathVariable String imgName) {
        if (imgService.checkAnswer(AnswerDto.toModelObject(answerDto), imgService.getByName(imgName))){
            return "redirect:/website/right";
        } else {
            return "redirect:/website/wrong/" + imgName;
        }
    }
}
