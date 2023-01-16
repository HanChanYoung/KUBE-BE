package kube.kubecamp.data.handler.impl;


import kube.kubecamp.data.dao.BoardDAO;
import kube.kubecamp.data.entity.BoardEntity;
import kube.kubecamp.data.handler.BoardDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class BoardDataHandlerImpl implements BoardDataHandler {

    BoardDAO boardDAO;

    @Autowired
    public BoardDataHandlerImpl(BoardDAO boardDAO){
        this.boardDAO =boardDAO;
    }

    @Override
    public BoardEntity saveBoardListEntity(String boardId, String providerId, int categoryId, LocalDateTime rentStartDate,
                                           LocalDateTime rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                           String delvyStatusCode, String boardAddr, LocalDateTime delDate, String imgSrc, boolean isDeleted){

        BoardEntity boardEntity = new BoardEntity(boardId, providerId, categoryId, rentStartDate, rentEndDate, boardName, boardDesc, price,
                                                    stateStatusCode, delvyStatusCode, boardAddr, delDate, imgSrc, isDeleted);

        return boardDAO.saveBoardList(boardEntity);

    }

    @Override
    public BoardEntity getBoardListEntity(String boardId){

        return boardDAO.getBoardList(boardId);
    }

}