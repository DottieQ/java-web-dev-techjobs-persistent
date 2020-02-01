package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @NotNull(message = "An entry is required.")
    @Size(min = 1, max = 2000, message = "The skills entered are longer than 2000 character limit.")
    public String skill;

    @NotNull(message = "An entry is required.")
    @Size(min = 1, max = 2000, message = "The description entered are longer than 2000 character limit.")
    public String description;

    public Skill() {}

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}