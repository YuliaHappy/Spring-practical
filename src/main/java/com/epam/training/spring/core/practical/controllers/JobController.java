package com.epam.training.spring.core.practical.controllers;

import com.epam.training.spring.core.practical.basic.Job;
import com.epam.training.spring.core.practical.services.JobEmplService;
import com.epam.training.spring.core.practical.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
@RequestMapping(value = {"/job"})
public class JobController {
    private final String ALL_JOB = "/allJobs";
    private final String JOB_ABOUT = "/jobAbout";
    private final String JOB_DELETE = "/jobDelete";
    private final String JOB_SAVE = "/jobSave";
    private final String JOB_APPOINT = "/jobAppoint";

    @Autowired
    @Qualifier("jobService")
    private JobService jobService;

    @Autowired
    @Qualifier("jobEmplService")
    private JobEmplService jobEmplService;

    @RequestMapping(value = ALL_JOB, method = RequestMethod.GET)
    public ModelAndView getAllJobs() {
        return new ModelAndView("job/allJobs", "jobs", jobService.getAll());
    }

    @RequestMapping(value = JOB_ABOUT + "/{id}", method = RequestMethod.GET)
    public ModelAndView getJobById(@PathVariable(value = "id") int id) {
        return new ModelAndView("job/jobAbout", "job", jobService.getById(id));
    }

    @RequestMapping(value = JOB_DELETE + "/{id}", method = RequestMethod.GET)
    public ModelAndView deleteJob(@PathVariable(value = "id") int id) {
        jobService.remove(id);
        return getAllJobs();
    }

    @RequestMapping(value = JOB_SAVE, method = RequestMethod.GET)
    public ModelAndView saveJob() {
        return new ModelAndView("job/addJob");
    }

    @RequestMapping(value = JOB_SAVE, method = RequestMethod.POST)
    public ModelAndView addJob(@RequestParam Map<String, String> parametrs) throws ParseException {
        jobService.register(
                new Job(new SimpleDateFormat("yyyy-MM-dd").parse(parametrs.get("deadline")), parametrs.get("description")));
        return getAllJobs();
    }

    @RequestMapping(value = JOB_APPOINT + "/{id}", method = RequestMethod.GET)
    public ModelAndView appointEmployee(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", jobEmplService.getAllEmployees());
        modelAndView.addObject("jobId", id);
        modelAndView.setViewName("job/appointEmployee");
        return modelAndView;
    }

    @RequestMapping(value = JOB_APPOINT, method = RequestMethod.POST)
    public ModelAndView setRelation(@RequestParam Map<String, String> parametrs) {
        jobService.appointEmployee(Integer.parseInt(parametrs.get("idJob")),
                jobEmplService.getEmployeeById(Integer.parseInt(parametrs.get("idEmployee"))));
        return getAllJobs();
    }
}
