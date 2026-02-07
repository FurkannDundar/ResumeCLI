package fd.resumecli.model;

import lombok.Data;

import java.util.List;

@Data
public class Experience {

    private String companyName;
    private String title;
    private List<String> descriptions;
    private String location;
    private String startingEndingDate;
}
