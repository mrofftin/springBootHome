package co.mr.demo_01_17.controller;

import co.mr.demo_01_17.model.Board;
import co.mr.demo_01_17.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/writeForm")
    public String writeForm(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null); // id값이 없을 경우에는 null 값으로 대체
            model.addAttribute("board", board);
        }
        return "board/write-form";
    }

    @PostMapping("/writeForm")
    public String writeForm(@ModelAttribute Board board) {
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
