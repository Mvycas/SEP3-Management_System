package group3;

import group3.DAO.EmployeeDAO;
import group3.DAO.IEmployeeDAO;
import group3.model.Employee;
import group3.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

@EnableJpaRepositories
@SpringBootApplication
public class PoCJava3Application implements CommandLineRunner {

    @Resource
    IEmployeeRepository employeeRepository;

    public static void main(String[] args) throws IOException
    {
        SpringApplication.run(PoCJava3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        new Tier3Server().run();
    }
}
