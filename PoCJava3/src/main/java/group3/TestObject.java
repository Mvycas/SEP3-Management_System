package group3;

import group3.model.Employee;
import group3.model.TransferObject;
import group3.model.User;
import group3.repository.IEmployeeRepository;
import group3.repository.IUserRepository;
import group3.util.BeanUtility;

import java.util.List;

public class TestObject {

    IUserRepository userRepository = BeanUtility.getApplicationContext().getBean(IUserRepository.class);
    IEmployeeRepository employeeRepository = BeanUtility.getApplicationContext().getBean(IEmployeeRepository.class);

    public TransferObject TestObject(Object object) {
        new TransferObject(null, null);
        Object request = null;
        String command = null;


        if (object instanceof TransferObject) {

            request = ((TransferObject) object).getObject();
            command = ((TransferObject) object).getCommand();
            System.out.println("Command: " + command);

            if (request instanceof User userObj) {

                switch (command) {
                    case "post" -> userRepository.save(userObj);
                    case "all" -> {
                        System.out.println("Finding All...");
                        request = userRepository.findAll();
                    }
                }
            }
            if (request instanceof Employee employeeObj) {

                switch (command) {
                    case "post" -> employeeRepository.save(employeeObj);
                    case "all" -> {
                        System.out.println("Finding All...");
                        request = employeeRepository.findAll();
                    }
                }
            }
        }
        return new TransferObject(request, command);
    }
}


