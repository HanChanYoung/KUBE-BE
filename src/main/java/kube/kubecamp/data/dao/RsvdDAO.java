package kube.kubecamp.data.dao;

import kube.kubecamp.data.entity.RsvdEntity;

public interface RsvdDAO {

    RsvdEntity saveRsvdList(RsvdEntity rsvdEntity);

    RsvdEntity getRsvdList(Long rsvdId);
}
