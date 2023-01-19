package kube.kubecamp.data.dao;

import kube.kubecamp.data.entity.RsvdEntity;

import java.util.List;


public interface RsvdDAO {

    RsvdEntity saveRsvdList(RsvdEntity rsvdEntity);

    RsvdEntity getRsvdList(Long boardId);

    List<RsvdEntity> getRsvdListAll();

}
