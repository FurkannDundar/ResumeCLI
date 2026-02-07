package fd.resumecli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Resume {
    private PersonalInformation personalInformation;
    @JsonProperty("education")
    private List<Education> educations;
    @JsonProperty("experience")
    private List<Experience> experiences;
    private List<Project> projects;
    private Skills skills;
}
