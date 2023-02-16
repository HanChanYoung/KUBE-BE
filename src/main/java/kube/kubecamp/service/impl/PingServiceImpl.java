package kube.kubecamp.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.*;
import java.util.*;

// state_info
//  M    S    state
//  S    S  —> 0
//  S    F  —> 1
//  F    S  —> 2
//  F    F  —> 3

public class PingServiceImpl {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public static boolean availablePort(String host, int port) {
        boolean result = false;

        try {
            (new Socket(host, port)).close();

            result = true;
        } catch (Exception e) {

        }
        return result;
    }

    public int PingCheck() {
        log.info("start");
        int statusCode = 0;
        int[] addressTmp = {10529, 10213};
        String[] addressName = {"DB-Master", "DB-Slave"};

        while (true) {
            List<String> StatusPing = new ArrayList<String>();
            for (int i = 0; i < addressTmp.length; i++) {

                try {

                    Thread.sleep(3000);

                    InetAddress targetIp = InetAddress.getByName("210.109.63.98");

                    boolean value = availablePort("210.109.63.98", addressTmp[i]);

                    if (value) {
                        StatusPing.add("S");
                    } else {
                        StatusPing.add("F");
                    }

                } catch (Exception e) {
                    //System.out.println(addressTmp[i] + "-" + addressName[i] + " ============== Exception");

                }

            }

            String masterStatus = StatusPing.get(0);
            String slaveStatus = StatusPing.get(1);

            if (masterStatus == "S" && slaveStatus == "S") {
                statusCode = 0;
            } else if (masterStatus == "S" && slaveStatus == "F") {
                statusCode = 1;
            } else if (masterStatus == "F" && slaveStatus == "S") {
                statusCode = 2;
            } else {
                statusCode = 3;
            }

            log.info("log {}",statusCode);
            return statusCode;
        }

    }
}

