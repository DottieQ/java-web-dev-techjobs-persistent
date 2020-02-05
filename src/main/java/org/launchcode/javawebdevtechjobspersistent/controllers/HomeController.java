package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @RequestMapping("")
    public String index(Model model, EmployerRepository employerRepository) {

        model.addAttribute("title", "My Jobs");
        model.addAttribute("employerId", employerRepository);

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model, EmployerRepository employerRepository, @RequestParam int employerId) {
        model.addAttribute("title", "Add Job");
        model.addAttribute("employerId", employerRepository);
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills, EmployerRepository employerRepository) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("employerId", employerRepository);
            return "add";
        }

       If (employerRepository.findById(employerId)) {

            model.addAttribute("title", "Add Job");
            model.addAttribute("employerId", employerRepository);

//            jobRepository.save(newJob);
//            model.addAttribute("skills", skillRepository.findAll());

            return "redirect:";
        }
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }


}
