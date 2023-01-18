package kube.kubecamp.service.impl;

import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.BoardDtoGet;
import kube.kubecamp.data.dto.BoardDtoGetAll;
import kube.kubecamp.data.entity.BoardEntity;
import kube.kubecamp.data.handler.BoardDataHandler;
import kube.kubecamp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    BoardDataHandler boardDataHandler;

    @Autowired
    public  BoardServiceImpl(BoardDataHandler boardDataHandler){
        this.boardDataHandler = boardDataHandler;
    }

    @Override
    public BoardDto saveBoardList(Long boardId, String providerId, String categoryName, LocalDate rentStartDate,
                                  LocalDate rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                  String delvyStatusCode, String boardAddr, String imgSrc, boolean isDeleted){

        BoardEntity boardEntity = boardDataHandler.saveBoardListEntity(boardId, providerId, categoryName, rentStartDate, rentEndDate, boardName, boardDesc, price,
                stateStatusCode, delvyStatusCode, boardAddr,  imgSrc, isDeleted);

        BoardDto boardDto = new BoardDto(boardEntity.getBoardId(),boardEntity.getProviderId(),boardEntity.getCategoryName(),boardEntity.getRentStartDate(),
                                            boardEntity.getRentEndDate(),boardEntity.getBoardName(),boardEntity.getBoardDesc(),boardEntity.getPrice(),
                                            boardEntity.getStateStatusCode(),boardEntity.getDelvyStatusCode(),boardEntity.getBoardAddr(),
                                            boardEntity.getImgSrc(),boardEntity.isDeleted());

        return boardDto;

    }

    @Override
    public BoardDtoGet getBoardList(Long boardId){

        BoardEntity boardEntity = boardDataHandler.getBoardListEntity(boardId);

        BoardDtoGet boardDtoGet = new BoardDtoGet(boardEntity.getBoardId(),boardEntity.getCategoryName(),boardEntity.getRentStartDate(),
                boardEntity.getRentEndDate(),boardEntity.getBoardName(),boardEntity.getBoardDesc(),boardEntity.getPrice(),
                boardEntity.getImgSrc());

        return boardDtoGet;
    }

    @Override
    public List<BoardDtoGetAll> getBoardListAll(){

        List<BoardEntity> boardEntityList = boardDataHandler.getBoardListAllEntity();
        List<BoardDtoGetAll> boardDtoList = new ArrayList<>();

        for(BoardEntity boardEntity:boardEntityList){
            BoardDtoGetAll boardDtoGetAll = BoardDtoGetAll.builder()
                    .boardId(boardEntity.getBoardId())
                    .boardName(boardEntity.getBoardName())
                    .boardDesc(boardEntity.getBoardDesc())
                    .categoryName(boardEntity.getCategoryName())
                    .price(boardEntity.getPrice())
                    .imgSrc(boardEntity.getImgSrc())
                    .rentStartDate(boardEntity.getRentStartDate())
                    .rentEndDate(boardEntity.getRentEndDate())
                    .build();

            boardDtoList.add(boardDtoGetAll);
        }
        return boardDtoList;


    }


}
