package com.example.springbootproject.controller;

import com.example.springbootproject.dto.BoardDto;
import com.example.springbootproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList",boardList);
        return "/board/list.html";
    }

    @GetMapping("/openAPITest")
    public String openAPITest(){
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
