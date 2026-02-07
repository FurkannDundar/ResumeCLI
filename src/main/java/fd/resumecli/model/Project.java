package fd.resumecli.model;

import lombok.Data;

import java.util.List;

@Data
public class Project {
    private String projectName;
    private String keyTechnologies;
    private List<String> descriptions;
}
