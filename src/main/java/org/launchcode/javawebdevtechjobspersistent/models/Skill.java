package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

//    @NotBlank(message = "An entry is required.")
//    @Size(max = 50, message = "The skills entered are longer than 50 character limit.")
//    public String skill;

    @NotBlank(message = "An entry is required.")
    @Size(max = 50, message = "The description entered are longer than 50 character limit.")
    public String description;

    public Skill() {}

//    public String getSkill() {
//        return skill;
//    }
//
//    public void setSkill(String skill) {
//        this.skill = skill;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}