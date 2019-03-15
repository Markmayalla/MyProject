package tz.co.comptech.m_safariproduction.ViewModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import tz.co.comptech.m_safariproduction.Model.Bus;
import tz.co.comptech.m_safariproduction.Model.BusCenter;
import tz.co.comptech.m_safariproduction.Repository.RouteRepository;

public class RouteViewModel extends ViewModel {
    RouteRepository repository;

    public RouteViewModel() {
        repository = new RouteRepository();
    }

    public LiveData<List<Bus>> searchRoute(String from, String to, String date) {
        return  repository.searchRoutes(from, to, date);
    }

    public void getCenters() {
        repository.populateCenters();
    }
}
