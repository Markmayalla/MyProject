package tz.co.comptech.m_safariproduction.Repository;

import tz.co.comptech.m_safariproduction.Api.AppConnection;
import tz.co.comptech.m_safariproduction.Api.BusWebServices.ScheduleWebService;

public class ScheduleRepository {
    ScheduleWebService webService;
    public ScheduleRepository() {
        webService = AppConnection.getClient().create(ScheduleWebService.class);
    }

    
}
