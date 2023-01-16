package kube.kubecamp.data.handler;

import kube.kubecamp.data.entity.BoardEntity;

import java.time.LocalDateTime;

public interface BoardDataHandler {

    BoardEntity saveBoardListEntity(String boardId, String providerId, int categoryId, LocalDateTime rentStartDate,
                                    LocalDateTime rentEndDate, String boardName, String boardDesc, float price, String stateStatusCode,
                                    String delvyStatusCode, String boardAddr, LocalDateTime delDate, String imgSrc, boolean isDeleted);

    BoardEntity getBoardListEntity(String boardId);
}
