package kube.kubecamp.controller;

import kube.kubecamp.data.dto.BoardDtoGet;
import kube.kubecamp.data.dto.RsvdDto;
import kube.kubecamp.service.RsvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/api")
public class RsvdController {

    private RsvdService rsvdService;

    @Autowired
    public RsvdController(RsvdService rsvdService) {
        this.rsvdService = rsvdService;
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");

    }

    @PostMapping("/reservation")
    public RsvdDto createRsvdList(@Valid @RequestBody RsvdDto rsvdDto) {

        Long rsvdId = rsvdDto.getRsvdId();
        Long boardId = rsvdDto.getBoardId();
        String lenderId = rsvdDto.getLenderId();
        LocalDate rentStartDate = rsvdDto.getRentStartDate();
        LocalDate rentEndDate = rsvdDto.getRentEndDate();
        String delvyOptionCode = rsvdDto.getDelvyOptionCode();
        String rsvdStatusCode = rsvdDto.getRsvdStatusCode();
        String lenderAddr = rsvdDto.getLenderAddr();
        boolean isDeleted = rsvdDto.isDeleted();

        return rsvdService.saveRsvdList(rsvdId, boardId, lenderId, rentStartDate, rentEndDate,
                delvyOptionCode, rsvdStatusCode, lenderAddr, isDeleted);
    }

    @GetMapping("/reservation/{boardid}")
    public RsvdDto getRsvdList(@PathVariable("boardid") Long boardId){
        return rsvdService.getRsvdList(boardId);
    }


}