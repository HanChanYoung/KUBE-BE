package kube.kubecamp.service;

import kube.kubecamp.data.dto.BoardDto;

import java.time.LocalDateTime;

public interface BoardService {


    BoardDto saveBoardList(String boardId, String providerId, int categoryId, LocalDateTime rentStartDate,
                            LocalDateTime rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                            String delvyStatusCode, String boardAddr, LocalDateTime delDate, String imgSrc, boolean isDeleted);

    BoardDto getBoardList(String boardId);
}
