package tz.co.comptech.m_safariproduction.Api;
/*
    Created in 05/11/2018

    This file extend AppConnection this hold all Bus Api's
 */
public class Bus extends AppConnection {
    /*
        Variable holding Bus Url extend from connection
     */
    public final static String busApi =  "buses/";
    public final static String requestTrip =  busApi + "schedule_request/";
    public final static String cancelTrip =  busApi + "schedule_canceling/";
    public final static String updateTrip =  busApi + "schedule_updating/";
    public final static String historyTrip =  busApi + "schedule_history/";
}

