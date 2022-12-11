package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManeger;
    public List<CarDto> findallCars(){
        LOG.info("findAllCars");
        try {
            TypedQuery<Car> typedQuery =entityManeger.createQuery("SELECT c from Car c",Car.class );
            List<Car> cars=typedQuery.getResultList();
            return copyCarsToDto(cars);
        }
        catch (Exception ex)
        {
            throw new EJBException();
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDto;
        carDto=cars
                .stream()
                .map(x->new CarDto(x.getId(),x.getLICENSEPLATE(),x.getPARKINGSPOT(),x.getOwner().getUsername())).collect(Collectors.toList());
        return carDto;
    }
}