package web.service;

import web.DAO.CarDao;
import web.DAO.CarDaoImpl;
import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService{

    private final CarDao dao;

    public CarServiceImpl() {
        dao = new CarDaoImpl();
    }

    @Override
    public List<Car> getCars(int number) {
        return dao.getCars(number);
    }
}
