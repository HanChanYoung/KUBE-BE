package kube.kubecamp.controller;


import kube.kubecamp.data.dao.impl.BoardDAOImpl;
import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.BoardDtoGet;
import kube.kubecamp.data.dto.BoardDtoGetAll;
import kube.kubecamp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
public class BoardController {

    private BoardService boardService;


    @Autowired
    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }

//    @ModelAttribute
//    public void setResponseHeader(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin","*");
//
//    }
    @GetMapping("/posts/{boardid}")
    public BoardDtoGet getBoardList(@PathVariable("boardid") Long boardId){
        return boardService.getBoardList(boardId);
    }

    @GetMapping("/posts")
    public List<BoardDtoGetAll> getBoardListAll(){
        return boardService.getBoardListAll();
    }

    @PostMapping("/posts")
    public BoardDto createBoardList(@Valid @RequestBody BoardDto boardDto){

        Long boardId = boardDto.getBoardId();
        String providerId = boardDto.getProviderId();
        String categoryName = boardDto.getCategoryName();
        LocalDate rentStartDate = boardDto.getRentStartDate();
        LocalDate rentEndDate = boardDto.getRentEndDate();
        String boardName = boardDto.getBoardName();
        String boardDesc = boardDto.getBoardDesc();
        float price = boardDto.getPrice();
        String stateStatusCode = boardDto.getStateStatusCode();
        String delvyStatusCode = boardDto.getDelvyStatusCode();
        String boardAddr = boardDto.getBoardAddr();
        String imgSrc = boardDto.getImgSrc();
        boolean isDeleted = boardDto.isDeleted();

        return boardService.saveBoardList(boardId, providerId, categoryName, rentStartDate, rentEndDate, boardName, boardDesc, price,
                stateStatusCode, delvyStatusCode, boardAddr, imgSrc, isDeleted);
    }


}
