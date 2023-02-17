package kube.kubecamp.data.db;

import kube.kubecamp.service.impl.PingServiceImpl;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {

    PingServiceImpl pingService = new PingServiceImpl();
    String front = pingService.getFront();
    String back = pingService.getBack();
    @Override
    protected Object determineCurrentLookupKey() {
        return (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) ? front : back;
    }


}

