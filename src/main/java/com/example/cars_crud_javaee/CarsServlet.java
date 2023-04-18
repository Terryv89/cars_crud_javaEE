package com.example.cars_crud_javaee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.CarRepository;

import java.io.IOException;

@WebServlet(name="Carsservlet",urlPatterns = {"/cars"})
public class CarsServlet extends HttpServlet {

    private CarRepository repository = new CarRepository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var cars = repository.GetAllCars();

        request.setAttribute("cars", cars);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cars/index.jsp");

        dispatcher.forward(request, response);

    }

}
