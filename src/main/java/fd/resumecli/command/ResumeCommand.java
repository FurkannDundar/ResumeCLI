package fd.resumecli.command;

import fd.resumecli.model.Resume;
import fd.resumecli.service.PdfGenerationService;
import fd.resumecli.service.ResumeService;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "resume-cli",
                    mixinStandardHelpOptions = true,
                    version = "1.0",
                    description = "JSON -> PDF dönüşümü yapar")
public class ResumeCommand implements Callable<Integer> {

    private final ResumeService resumeService;
    private final PdfGenerationService pdfGenerationService;

    public ResumeCommand(ResumeService resumeService, PdfGenerationService pdfGenerationService) {
        this.resumeService = resumeService;
        this.pdfGenerationService = pdfGenerationService;
    }

    @CommandLine.Option(names = {"-i", "--input"},
                        description = "JSON dosyasının yolu",
                        required = true)
    private String jsonFilePath;

    @CommandLine.Option(names = {"-o", "--output"},
                        description = "PDF dosyasının yolu",
                        required = true)
    private String outputPath;

    @Override
    public Integer call() throws Exception {
        System.out.println("ResumeCLI Başlatıldı");
        System.out.println("Okunuyor: " + jsonFilePath);

        try{
            Resume resume = resumeService.loadResume(jsonFilePath);
            System.out.println("PDF Oluşturuluyor");
            pdfGenerationService.generate(resume, outputPath);
            System.out.println("PDF Oluşturuldu");
            return 0;
        }catch(Exception e){
            System.out.println("Hata: " + e.getMessage());
            return 1;
        }
    }
}
