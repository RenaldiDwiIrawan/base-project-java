package id.base_project.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"id.base_project"})
@EntityScan({"id.base_project.dao.entity"})
@EnableJpaRepositories(basePackages = {"id.base_project.dao.repository"})

public class BaseProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseProjectApplication.class);
    }
}
