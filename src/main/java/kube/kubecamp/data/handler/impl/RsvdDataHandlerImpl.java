package kube.kubecamp.data.handler.impl;


import kube.kubecamp.data.dao.RsvdDAO;
import kube.kubecamp.data.entity.RsvdEntity;
import kube.kubecamp.data.handler.RsvdDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
public class RsvdDataHandlerImpl implements RsvdDataHandler {

    RsvdDAO rsvdDAO;

    @Autowired
    public RsvdDataHandlerImpl(RsvdDAO rsvdDAO) {
        this.rsvdDAO = rsvdDAO;
    }

    @Override
    public RsvdEntity saveRsvdListEntity(Long rsvdId, Long boardId, String lenderId, LocalDate rentStartDate,
                                         LocalDate rentEndDate, String delvyOptionCode, String rsvdStatusCode,
                                         String lenderAddr, boolean isDeleted)
    {

        RsvdEntity rsvdEntity = new RsvdEntity(rsvdId, boardId, lenderId, rentStartDate, rentEndDate,
                delvyOptionCode, rsvdStatusCode, lenderAddr, isDeleted);

        return rsvdDAO.saveRsvdList(rsvdEntity);

    }

    @Override
    public RsvdEntity getRsvdListEntity(Long rsvdId) {

        return rsvdDAO.getRsvdList(rsvdId);
    }

}
