package kube.kubecamp.data.handler;

import kube.kubecamp.data.entity.BoardEntity;

import java.time.LocalDate;

public interface BoardDataHandler {

    BoardEntity saveBoardListEntity(Long boardId, String providerId, int categoryId, LocalDate rentStartDate,
                                    LocalDate rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                    String delvyStatusCode, String boardAddr, LocalDate delDate, String imgSrc, boolean isDeleted);

    BoardEntity getBoardListEntity(Long boardId);
}
