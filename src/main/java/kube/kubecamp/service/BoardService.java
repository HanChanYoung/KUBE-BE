package kube.kubecamp.service;

import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.BoardDtoGet;

import java.time.LocalDate;

public interface BoardService {


    BoardDto saveBoardList(Long boardId, String providerId, String categoryName, LocalDate rentStartDate,
                            LocalDate rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                            String delvyStatusCode, String boardAddr,  String imgSrc, boolean isDeleted);

    BoardDtoGet getBoardList(Long boardId);
}
