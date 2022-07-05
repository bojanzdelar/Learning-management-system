package ca.utoronto.lms.faculty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"ca.utoronto.lms.faculty", "ca.utoronto.lms.shared"})
@ComponentScan({"ca.utoronto.lms.faculty", "ca.utoronto.lms.shared"})
public class FacultyServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FacultyServiceApplication.class, args);
    }
}
