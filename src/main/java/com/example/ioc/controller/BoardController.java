// src/main/java/com/example/ioc/controller/BoardController.java
package com.example.ioc.controller;

import com.example.ioc.dao.BoardDao;
import com.example.ioc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardDao boardDao;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardDao.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Board board = boardDao.findById(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute Board board) {
        boardDao.insert(board);
        return "redirect:/board/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        boardDao.delete(id);
        return "redirect:/board/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Board board) {
        boardDao.update(board);
        return "redirect:/board/detail/" + board.getId();
    }
}
