package fd.resumecli;

import fd.resumecli.command.ResumeCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class ResumeCliApplication implements CommandLineRunner, ExitCodeGenerator {

    private final CommandLine.IFactory factory;
    private final ResumeCommand resumeCommand;
    private int exitCode;

    public ResumeCliApplication(CommandLine.IFactory factory, ResumeCommand resumeCommand) {
        this.factory = factory;
        this.resumeCommand = resumeCommand;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(ResumeCliApplication.class, args)));
    }

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(resumeCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
       return exitCode;
    }
}