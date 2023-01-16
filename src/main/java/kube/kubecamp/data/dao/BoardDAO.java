package kube.kubecamp.data.dao;

import kube.kubecamp.data.entity.BoardEntity;

public interface BoardDAO {

    BoardEntity saveBoardList(BoardEntity boardEntity);

    BoardEntity getBoardList(String boardId);
}
