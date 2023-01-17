package kube.kubecamp.controller;


import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.BoardDtoGet;
import kube.kubecamp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;


@RestController
@RequestMapping("/api")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService=boardService;}

    @GetMapping("/posts/{boardId}")
    public BoardDtoGet getBoardList(@PathVariable Long boardId){
        return boardService.getBoardList(boardId);
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
