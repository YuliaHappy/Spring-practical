package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.basic.Employee;
import com.epam.training.spring.core.practical.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = {"/employee"})
public class EmployeeController {
    private final String ALL_EMPLOYEE = "/allEmployees";
    private final String EMPLOYEE_ABOUT = "/employeeAbout";
    private final String EMPLOYEE_DELETE = "/employeeDelete";
    private final String EMPLOYEE_SAVE = "/employeeSave";
    private final String ALL_JOBS = "/allJobs";

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @RequestMapping(value = ALL_EMPLOYEE, method = RequestMethod.GET)
    public ModelAndView getAllEmployees() {
        return new ModelAndView("employee/allEmployees", "employees", employeeService.getAll());
    }

    @RequestMapping(value = EMPLOYEE_ABOUT + "/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployeeById(@PathVariable(value = "id") int id) {
        return new ModelAndView("employee/employeeAbout", "employee", employeeService.getById(id));
    }

    @RequestMapping(value = EMPLOYEE_DELETE + "/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable(value = "id") int id) {
        employeeService.remove(id);
        return getAllEmployees();
    }

    @RequestMapping(value = EMPLOYEE_SAVE, method = RequestMethod.GET)
    public ModelAndView saveJob() {
        return new ModelAndView("employee/addEmployee");
    }

    @RequestMapping(value = EMPLOYEE_SAVE, method = RequestMethod.POST)
    public ModelAndView addJob(@RequestParam Map<String, String> parametrs)  {
        employeeService.register(
                new Employee(parametrs.get("name")));
        return getAllEmployees();
    }

    @RequestMapping(value = ALL_JOBS + "/{id}", method = RequestMethod.GET)
    public ModelAndView allJobs(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", employeeService.getAllJobs(id));
        modelAndView.addObject("idEmployee", id);
        modelAndView.setViewName("employee/allJobs");
        return modelAndView;
    }
}
