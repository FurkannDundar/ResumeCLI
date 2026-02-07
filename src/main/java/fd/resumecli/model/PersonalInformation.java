package fd.resumecli.model;

import lombok.Data;

@Data
public class PersonalInformation {
    private String fullName;
    private String title;
    private String phoneNumber;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String websiteUrl;
}
