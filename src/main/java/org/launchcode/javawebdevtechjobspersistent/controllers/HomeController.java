package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model, EmployerRepository employerRepository) {

        model.addAttribute("title", "My Jobs");
     //   model.addAttribute("employerId", employerRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
       // model.addAttribute("employerId", employerRepository);
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam(required = false) Integer employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
        //    model.addAttribute("employerId", employerRepository);
            return "add";
        }

//        if (employerId == null) {
//            model.addAttribute("title", "Add Job");
//            model.addAttribute("employers", employerRepository.findAll());
//        }

       Optional<Employer> selection = employerRepository.findById(employerId);
//        if (selection.isEmpty()) {
//            model.addAttribute("title", "Invalid employer selection: " + employerId);
//        } else {
            jobRepository.save(newJob);
            Employer employer =  selection.get();
        model.addAttribute("employer", employerRepository.findById(employerId));
 //           model.addAttribute("employer", employer.getName());
  //          model.addAttribute("employerId", employer.getId());
         //   newJob.set(employer);

  //      }

            return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }


}
