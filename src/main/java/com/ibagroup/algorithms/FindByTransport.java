package com.ibagroup.algorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ibagroup.dao.ITripDao;
import com.ibagroup.dto.Trip;

/**
 * @author DubininaE
 */
public class FindByTransport implements IAlgorythmRealisation{
    private ITripDao dao;
    private Long p1;
    private Long p2;
    private String transport;

    public FindByTransport(ITripDao dao, Long p1, Long p2, String transport) {
        this.dao = dao;
        this.p1 = p1;
        this.p2 = p2;
        this.transport = transport;
    }

    @Override
    public List<Trip> algo() {
        List<Trip>trips = dao.findAll();
        for (Trip t : trips) {
            if (t.getCityFrom().equals(p1) && t.getCityTo().equals(p2)&&t.getTransport().equals(transport)) {
            } else {
                trips.remove(t);
            }
        }
        Collections.sort(trips, new Comparator<Trip>() {
            public int compare(Trip o1, Trip o2) {
                return o1.getCost().compareTo(o2.getCost());
            }
        });
        return trips;
    }
}
