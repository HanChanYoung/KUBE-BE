package kube.kubecamp.repository;


import kube.kubecamp.data.dto.BoardDtoGetAll;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RedisBoardGetAllRepository extends CrudRepository<BoardDtoGetAll,Long> {

    @Override
    List<BoardDtoGetAll> findAll();
}
