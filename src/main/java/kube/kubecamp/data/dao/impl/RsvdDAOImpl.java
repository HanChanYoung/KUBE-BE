package kube.kubecamp.data.dao.impl;


import kube.kubecamp.data.dao.RsvdDAO;
import kube.kubecamp.data.entity.RsvdEntity;
import kube.kubecamp.repository.RsvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RsvdDAOImpl implements RsvdDAO {

    RsvdRepository rsvdRepository;

    @Autowired
    public RsvdDAOImpl(RsvdRepository rsvdRepository) {
        this.rsvdRepository = rsvdRepository;
    }

    @Override
    public RsvdEntity saveRsvdList(RsvdEntity rsvdEntity) {
        rsvdRepository.save(rsvdEntity);
        return rsvdEntity;
    }

    @Override
    public RsvdEntity getRsvdList(Long rsvdId) {
        RsvdEntity rsvdEntity = rsvdRepository.getById(rsvdId);
        return rsvdEntity;
    }

}