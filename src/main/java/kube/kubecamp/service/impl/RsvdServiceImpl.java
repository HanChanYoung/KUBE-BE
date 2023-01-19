package kube.kubecamp.service.impl;

import kube.kubecamp.data.dto.RsvdDto;
import kube.kubecamp.data.entity.RsvdEntity;
import kube.kubecamp.data.handler.RsvdDataHandler;
import kube.kubecamp.service.RsvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RsvdServiceImpl implements RsvdService {

    RsvdDataHandler rsvdDataHandler;

    @Autowired
    public RsvdServiceImpl(RsvdDataHandler rsvdDataHandler) {
        this.rsvdDataHandler = rsvdDataHandler;
    }

    @Override
    public RsvdDto saveRsvdList(Long rsvdId, Long boardId, String lenderId, LocalDate rentStartDate, LocalDate rentEndDate,
                                String delvyOptionCode, String rsvdStatusCode, String lenderAddr, boolean isDeleted)

    {

        RsvdEntity rsvdEntity = rsvdDataHandler.saveRsvdListEntity(rsvdId, boardId, lenderId, rentStartDate, rentEndDate,
                delvyOptionCode, rsvdStatusCode, lenderAddr, isDeleted);

        RsvdDto rsvdDto = new RsvdDto(rsvdEntity.getRsvdId(), rsvdEntity.getBoardId(), rsvdEntity.getLenderId(),
                rsvdEntity.getRentStartDate(), rsvdEntity.getRentEndDate(), rsvdEntity.getDelvyOptionCode(),
                rsvdEntity.getRsvdStatusCode(), rsvdEntity.getLenderAddr(), rsvdEntity.isDeleted());

        return rsvdDto;

    }

    @Override
    public RsvdDto getRsvdList(Long boardId) {

        RsvdEntity rsvdEntity = rsvdDataHandler.getRsvdListEntity(boardId);

        RsvdDto rsvdDto = new RsvdDto(rsvdEntity.getRsvdId(), rsvdEntity.getBoardId(), rsvdEntity.getLenderId(),
                rsvdEntity.getRentStartDate(), rsvdEntity.getRentEndDate(), rsvdEntity.getDelvyOptionCode(),
                rsvdEntity.getLenderAddr(), rsvdEntity.getRsvdStatusCode(), rsvdEntity.isDeleted());

        return rsvdDto;
    }




}
