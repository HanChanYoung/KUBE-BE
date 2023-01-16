package kube.kubecamp.data.dao.impl;

import kube.kubecamp.data.dao.BoardDAO;
import kube.kubecamp.data.entity.BoardEntity;
import kube.kubecamp.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAOImpl implements BoardDAO {

    BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository){
        this.boardRepository =boardRepository;
    }

    @Override
    public BoardEntity saveBoardList(BoardEntity boardEntity){
        boardRepository.save(boardEntity);
        return boardEntity;
    }
    @Override
    public BoardEntity getBoardList(String boardId){
        BoardEntity boardEntity = boardRepository.getById(boardId);
        return boardEntity;
    }

}
