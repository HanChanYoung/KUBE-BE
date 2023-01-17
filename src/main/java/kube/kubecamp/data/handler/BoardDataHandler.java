package kube.kubecamp.data.handler;

import kube.kubecamp.data.entity.BoardEntity;

import java.time.LocalDate;

public interface BoardDataHandler {

    BoardEntity saveBoardListEntity(Long boardId, String providerId, String categoryName, LocalDate rentStartDate,
                                    LocalDate rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                    String delvyStatusCode, String boardAddr, String imgSrc, boolean isDeleted);

    BoardEntity getBoardListEntity(Long boardId);
}
