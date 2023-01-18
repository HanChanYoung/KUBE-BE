package kube.kubecamp.data.handler;

import kube.kubecamp.data.entity.RsvdEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface RsvdDataHandler {

    RsvdEntity saveRsvdListEntity(Long rsvdId, Long boardId, String lenderId, LocalDate rentStartDate, LocalDate rentEndDate,
                                  String delvyOptionCode, String rsvdStatusCode, String lenderAddr, boolean isDeleted);

    RsvdEntity getRsvdListEntity(Long rsvdId);
}