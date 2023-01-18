package kube.kubecamp.data.dao;

import kube.kubecamp.data.entity.BoardEntity;

import java.util.List;

public interface BoardDAO {

    BoardEntity saveBoardList(BoardEntity boardEntity);

    BoardEntity getBoardList(Long boardId);

    List<BoardEntity> getBoardListAll();
}
