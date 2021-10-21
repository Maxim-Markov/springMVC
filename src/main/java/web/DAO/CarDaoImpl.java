package web.DAO;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {
    private final List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("Chevrolet","Cruze","gray"));
        cars.add(new Car("BMW","e39","black"));
        cars.add(new Car("Skoda","Codiaq","blue"));
        cars.add(new Car("Audi","100","white"));
        cars.add(new Car("Porsche","911","red"));
    }

    public List<Car> getCars(int number){
        if(number < 0){
            number = cars.size();
        }
        return cars.stream().limit(number).collect(Collectors.toList());
    }

}
