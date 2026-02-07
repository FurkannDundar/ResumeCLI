package fd.resumecli.service;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import fd.resumecli.model.Resume;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
public class PdfGenerationService {

    private final TemplateEngine templateEngine;

    public PdfGenerationService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void generate(Resume resume, String outputPath) throws FileNotFoundException {
        Context context = new Context();
        context.setVariable("resume", resume);

        String htmlContent = templateEngine.process("resume", context);

        try(OutputStream os = new FileOutputStream(outputPath)){
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();

            InputStream fontStream = new ClassPathResource("fonts/Tinos-Regular.ttf").getInputStream();

            File tempFontFile = File.createTempFile("resume_font", ".ttf");
            tempFontFile.deleteOnExit();

            Files.copy(fontStream, tempFontFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            builder.useFont(tempFontFile, "Times New Roman");
            builder.withHtmlContent(htmlContent, null);
            builder.toStream(os);
            builder.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}