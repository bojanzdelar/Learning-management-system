package ca.utoronto.lms.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"ca.utoronto.lms.subject", "ca.utoronto.lms.shared"})
@ComponentScan({"ca.utoronto.lms.subject", "ca.utoronto.lms.shared"})
public class SubjectServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectServiceApplication.class, args);
    }
}
