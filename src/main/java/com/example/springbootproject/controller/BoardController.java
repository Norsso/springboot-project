package com.example.springbootproject.controller;

import com.example.springbootproject.dto.BoardDto;
import com.example.springbootproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String list(){
        return "/board/list.html";
    }

    @GetMapping("/openAPITest")
    public String test(){
        return "/board/openAPI.html";
    }

    @GetMapping("/writing")
    public String write(){
        return "board/write.html";
    }
    @PostMapping("/writing")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

}
