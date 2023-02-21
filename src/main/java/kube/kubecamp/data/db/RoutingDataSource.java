package kube.kubecamp.data.db;

import kube.kubecamp.service.impl.PingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {

    PingServiceImpl pingService = new PingServiceImpl();
    String front = pingService.getFront();
    String back = pingService.getBack();

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public Object determineCurrentLookupKey() {
        log.info("happys {}",front);
        log.info("kkkkkk {}",back);
        log.info("asd {}",TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        String a = "master";
        if(TransactionSynchronizationManager.isCurrentTransactionReadOnly()){
            a="slave";
        }
        return (a);
    }


}

