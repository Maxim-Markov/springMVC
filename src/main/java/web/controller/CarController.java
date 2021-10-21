package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars;
        if (count == null || count >= 5) {
            cars = new CarServiceImpl().getCars(-1);
        } else {
            cars = new CarServiceImpl().getCars(count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
