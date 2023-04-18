package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import models.Car;

import java.util.List;

public class CarRepository {

    private EntityManager entityManager;

    public CarRepository() {
        var emf = Persistence.createEntityManagerFactory("default");
        entityManager = emf.createEntityManager();
    }

    public List<Car> GetAllCars(){
       var query = entityManager.createQuery("SELECT c FROM Car c", Car.class);
       var cars = query.getResultList();
       return cars;
    }

}
