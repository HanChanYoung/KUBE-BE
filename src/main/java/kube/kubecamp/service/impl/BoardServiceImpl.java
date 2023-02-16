package kube.kubecamp.service.impl;

import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.BoardDtoGet;
import kube.kubecamp.data.dto.BoardDtoGetAll;
import kube.kubecamp.data.entity.BoardEntity;
import kube.kubecamp.data.entity.RsvdEntity;
import kube.kubecamp.data.handler.BoardDataHandler;
import kube.kubecamp.data.handler.RsvdDataHandler;
import kube.kubecamp.repository.RedisBoardGetAllRepository;
import kube.kubecamp.repository.RedisBoardGetRepository;
import kube.kubecamp.repository.RedisBoardRepository;
import kube.kubecamp.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    BoardDataHandler boardDataHandler;
    RsvdDataHandler rsvdDataHandler;

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final RedisBoardRepository redisBoardRepository;
    private final RedisBoardGetRepository redisBoardGetRepository;
    private final RedisBoardGetAllRepository redisBoardGetAllRepository;
    @Autowired
    public  BoardServiceImpl(BoardDataHandler boardDataHandler,RsvdDataHandler rsvdDataHandler,
                             RedisBoardRepository redisBoardRepository,RedisBoardGetRepository redisBoardGetRepository,
                             RedisBoardGetAllRepository redisBoardGetAllRepository){
        this.boardDataHandler = boardDataHandler;
        this.rsvdDataHandler = rsvdDataHandler;
        this.redisBoardRepository = redisBoardRepository;
        this.redisBoardGetRepository = redisBoardGetRepository;
        this.redisBoardGetAllRepository = redisBoardGetAllRepository;
    }



 //   @Transactional(readOnly = false)
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

        //redisBoardRepository.save(boardDto);
        log.info("Cache Data Saved!!!");

        log.info("Response DTO : {}",boardDto);
        return boardDto;

    }


//    @Transactional(readOnly = true)
    @Override
    public BoardDtoGet getBoardList(Long boardId){
        long startTime = System.currentTimeMillis();

        BoardEntity boardEntity = boardDataHandler.getBoardListEntity(boardId);
        List<RsvdEntity> rsvdEntityList = rsvdDataHandler.getRsvdListAllEntity();


        List<LocalDate> localDateList = new ArrayList<>();
        List<List<LocalDate>> localDateList2 = new ArrayList<List<LocalDate>>();

        for(RsvdEntity rsvdEntity2:rsvdEntityList){
            if((rsvdEntity2.getBoardId()==boardId)) {

                localDateList = getReservedDate(rsvdEntity2.getRentStartDate(), rsvdEntity2.getRentEndDate());
                localDateList.add(rsvdEntity2.getRentEndDate());
                localDateList2.add(localDateList);

            }
        }

//        Optional<BoardDtoGet> foundResponseDto = redisBoardGetRepository.findById(boardId);
//        if (foundResponseDto.isPresent()) {
//            log.info("Cache Data is exist");
//            log.info("[getBoard] Response ::  Response Time = {}ms", (System.currentTimeMillis() - startTime));
//            log.info("\n\n\n\n\n\n\n\n\n\n\n\n\n {}",foundResponseDto);
//
//
//            return foundResponseDto.get();
//        }
//        else{
//            log.info("Cache Data does NOT exist");
//            log.info("Cache Data Saving...\n...\n...\n...");
//
//            BoardDtoGet boardDtoGet = new BoardDtoGet(boardEntity.getBoardId(),boardEntity.getCategoryName(),boardEntity.getRentStartDate(),
//                    boardEntity.getRentEndDate(),boardEntity.getBoardName(),boardEntity.getBoardDesc(),boardEntity.getPrice(),
//                    boardEntity.getImgSrc(),localDateList2);
//
//            log.info("\n\n\n\n\n\n\n\n\n\n\n\n\n {}",boardDtoGet.getReservedDate());
//            redisBoardGetRepository.save(boardDtoGet);
//
//        }
        BoardDtoGet boardDtoGet = new BoardDtoGet(boardEntity.getBoardId(),boardEntity.getCategoryName(),boardEntity.getRentStartDate(),
                boardEntity.getRentEndDate(),boardEntity.getBoardName(),boardEntity.getBoardDesc(),boardEntity.getPrice(),
                boardEntity.getImgSrc(),localDateList2);

        log.info("Cache Data Saved!!!");
        log.info("[getBoard] Response ::  Response Time = {}ms", (System.currentTimeMillis() - startTime));
        //log.info("Response DTO : {}",boardDtoGet);

        return boardDtoGet;
    }

//    @Transactional(readOnly = true)
    @Override
    public List<BoardDtoGetAll> getBoardListAll() {
        long startTime = System.currentTimeMillis();

        List<BoardEntity> boardEntityList = boardDataHandler.getBoardListAllEntity();

//        List<BoardDtoGetAll> boardDtoGetAllList = redisBoardGetAllRepository.findAll();
//        log.info("\n\n\n\n\n\n\n\n\n\n\n {}",boardDtoGetAllList);
//
//        if(!CollectionUtils.isEmpty(boardDtoGetAllList)&&(boardDtoGetAllList.contains(null)==false)){
//            log.info("Cache Data is exist");
//            log.info("[getBoard] Response ::  Response Time = {}ms", (System.currentTimeMillis() - startTime));
//
//            return boardDtoGetAllList;
//        }
//        else{
//            log.info("Cache Data does NOT exist");
//            log.info("Cache Data Saving...\n...\n...\n...");
//
//            List<BoardDtoGetAll> boardDtoList = new ArrayList<>();
//            for (BoardEntity boardEntity : boardEntityList) {
//                BoardDtoGetAll boardDtoGetAll = BoardDtoGetAll.builder()
//                        .boardId(boardEntity.getBoardId())
//                        .boardName(boardEntity.getBoardName())
//                        .boardDesc(boardEntity.getBoardDesc())
//                        .categoryName(boardEntity.getCategoryName())
//                        .price(boardEntity.getPrice())
//                        .imgSrc(boardEntity.getImgSrc())
//                        .rentStartDate(boardEntity.getRentStartDate())
//                        .rentEndDate(boardEntity.getRentEndDate())
//                        .build();
//
//                 redisBoardGetAllRepository.save(boardDtoGetAll);
//
//            }
//
//
//                log.info("Cache Data Saved!!!");
//
//        }


            List<BoardDtoGetAll> boardDtoList = new ArrayList<>();

            for (BoardEntity boardEntity : boardEntityList) {
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

    public List<LocalDate> getReservedDate(LocalDate startDate, LocalDate endDate){
        return startDate.datesUntil(endDate)
                .collect(Collectors.toList());
    }


}
