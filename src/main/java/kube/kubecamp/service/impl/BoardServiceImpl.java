package kube.kubecamp.service.impl;

import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.BoardDtoGet;
import kube.kubecamp.data.entity.BoardEntity;
import kube.kubecamp.data.handler.BoardDataHandler;
import kube.kubecamp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoardServiceImpl implements BoardService {

    BoardDataHandler boardDataHandler;

    @Autowired
    public  BoardServiceImpl(BoardDataHandler boardDataHandler){
        this.boardDataHandler = boardDataHandler;
    }

    @Override
    public BoardDto saveBoardList(String boardId, String providerId, int categoryId, LocalDateTime rentStartDate,
                                  LocalDateTime rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                  String delvyStatusCode, String boardAddr, LocalDateTime delDate, String imgSrc, boolean isDeleted){

        BoardEntity boardEntity = boardDataHandler.saveBoardListEntity(boardId, providerId, categoryId, rentStartDate, rentEndDate, boardName, boardDesc, price,
                stateStatusCode, delvyStatusCode, boardAddr, delDate, imgSrc, isDeleted);

        BoardDto boardDto = new BoardDto(boardEntity.getBoardId(),boardEntity.getProviderId(),boardEntity.getCategoryId(),boardEntity.getRentStartDate(),
                                            boardEntity.getRentEndDate(),boardEntity.getBoardName(),boardEntity.getBoardDesc(),boardEntity.getPrice(),
                                            boardEntity.getStateStatusCode(),boardEntity.getDelvyStatusCode(),boardEntity.getBoardAddr(),boardEntity.getDelDate(),
                                            boardEntity.getImgSrc(),boardEntity.isDeleted());

        return boardDto;

    }

    @Override
    public BoardDtoGet getBoardList(String boardId){

        BoardEntity boardEntity = boardDataHandler.getBoardListEntity(boardId);

        BoardDtoGet boardDtoGet = new BoardDtoGet(boardEntity.getBoardId(),boardEntity.getCategoryId(),boardEntity.getRentStartDate(),
                boardEntity.getRentEndDate(),boardEntity.getBoardName(),boardEntity.getBoardDesc(),boardEntity.getPrice(),
                boardEntity.getImgSrc());

        return boardDtoGet;
    }



}
