package kube.kubecamp.service.impl;
import kube.kubecamp.data.db.RoutingDataSource;
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

    public String front;
    public String back;
    public int option;



    public void PingCheck() {



            System.out.println("Start");
            //boolean result = false;

            String[] hostTmp = {"172.16.67.141", "172.16.66.2"};
            int[] addressTmp = {3306, 3307};
            String[] addressName = {"DB-Master", "DB-Slave"};

            while (true) {
                List<String> StatusPing = new ArrayList<String>();
                for (int i = 0; i < addressTmp.length; i++) {

                    try {

                        Thread.sleep(1000);

                        InetAddress targetIp = InetAddress.getByName(hostTmp[i]);
                        boolean result = false;
                        try {
                            (new Socket(hostTmp[i], addressTmp[i])).close();

                            result = true;
                        } catch (Exception e) {

                        }
                        // boolean value = availablePort("210.109.63.98", addressTmp[i]);
                        boolean value = result;

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
                    front = "slave";
                    back = "master";
                    option = 0;

                } else if (masterStatus == "S" && slaveStatus == "F") {
                    front = "slave";
                    back = "master";
                    option = 1;

                } else if (masterStatus == "F" && slaveStatus == "S") {
                    front = "master";
                    back = "slave";
                    option = 2;

                } else {

                }

                System.out.println(option);


            }

        }
        public String getFront(){
            return this.front;
        }
        public String getBack(){
            return this.back;
        }
        public int getOption(){return this.option;}



    }


