package kube.kubecamp.controller;


import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService=boardService;}


    @PostMapping("/posts")
    public BoardDto createBoardList(@Valid @RequestBody BoardDto boardDto){

        String boardId = boardDto.getBoardId();
        String providerId = boardDto.getProviderId();
        int categoryId = boardDto.getCategoryId();
        LocalDateTime rentStartDate = boardDto.getRentStartDate();
        LocalDateTime rentEndDate = boardDto.getRentEndDate();
        String boardName = boardDto.getBoardName();
        String boardDesc = boardDto.getBoardDesc();
        float price = boardDto.getPrice();
        String stateStatusCode = boardDto.getStateStatusCode();
        String delvyStatusCode = boardDto.getDelvyStatusCode();
        String boardAddr = boardDto.getBoardAddr();
        LocalDateTime delDate = boardDto.getDelDate();
        String imgSrc = boardDto.getImgSrc();
        boolean isDeleted = boardDto.isDeleted();

        return boardService.saveBoardList(boardId, providerId, categoryId, rentStartDate, rentEndDate, boardName, boardDesc, price,
                stateStatusCode, delvyStatusCode, boardAddr, delDate, imgSrc, isDeleted);
    }


}
