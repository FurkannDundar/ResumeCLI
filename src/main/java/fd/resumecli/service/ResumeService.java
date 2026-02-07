package fd.resumecli.service;

import fd.resumecli.model.Resume;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class ResumeService {

    public Resume loadResume(String filePath) throws FileNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File(filePath);

        if(!jsonFile.exists()){
            throw new FileNotFoundException("Dosya Bulunamadı");
        }
        return mapper.readValue(jsonFile, Resume.class);
    }
}
