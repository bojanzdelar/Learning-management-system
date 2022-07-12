package ca.utoronto.lms.faculty;

import ca.utoronto.lms.faculty.model.Administrator;
import ca.utoronto.lms.faculty.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupRunner implements ApplicationRunner {
    @Autowired private AdministratorRepository administratorRepository;

    @Override
    public void run(ApplicationArguments args) {
        List<Administrator> administrators =
                (List<Administrator>) administratorRepository.findAll();

        if (administrators.isEmpty()) {
            administratorRepository.save(
                    Administrator.builder()
                            .id(1337L)
                            .userId(1337L)
                            .firstName("Bojan")
                            .lastName("Zdelar")
                            .build());
        }
    }
}
