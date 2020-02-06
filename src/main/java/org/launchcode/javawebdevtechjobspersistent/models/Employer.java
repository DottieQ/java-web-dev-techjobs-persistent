package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @OneToMany(mappedBy = "employer")
    //  @NotNull(message = "Please add an employer.")
   // @JoinColumn
    private final List<Job> jobs = new ArrayList<>();


    @NotBlank(message = "A location is required.")
    @Size(max = 50, message = "The location entered is longer than 50 character limit.")
    public String location;

    public Employer() {}

    public List<Job> getJobs() {
        return jobs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
