package kube.kubecamp.service;

import kube.kubecamp.data.dto.BoardDto;
import kube.kubecamp.data.dto.RsvdDto;

import java.time.LocalDate;

public interface RsvdService {

    RsvdDto saveRsvdList(Long rsvdId, Long boardId, String lenderId, LocalDate rentStartDate, LocalDate rentEndDate,
                         String delvyOptionCode, String lenderAddr, String rsvdStatusCode, boolean isDeleted);

    RsvdDto getRsvdList(Long rsvdId);

}