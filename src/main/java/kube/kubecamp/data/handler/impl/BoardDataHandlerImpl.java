package kube.kubecamp.data.handler.impl;


import kube.kubecamp.data.dao.BoardDAO;
import kube.kubecamp.data.entity.BoardEntity;
import kube.kubecamp.data.handler.BoardDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@Transactional
public class BoardDataHandlerImpl implements BoardDataHandler {

    BoardDAO boardDAO;

    @Autowired
    public BoardDataHandlerImpl(BoardDAO boardDAO){
        this.boardDAO =boardDAO;
    }

    @Override
    public BoardEntity saveBoardListEntity(Long boardId, String providerId, String categoryName, LocalDate rentStartDate,
                                           LocalDate rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                           String delvyStatusCode, String boardAddr, String imgSrc, boolean isDeleted){

        BoardEntity boardEntity = new BoardEntity(boardId, providerId, categoryName, rentStartDate, rentEndDate, boardName, boardDesc, price,
                                                    stateStatusCode, delvyStatusCode, boardAddr, imgSrc, isDeleted);

        return boardDAO.saveBoardList(boardEntity);

    }

    @Override
    public BoardEntity getBoardListEntity(Long boardId){

        return boardDAO.getBoardList(boardId);
    }

}
