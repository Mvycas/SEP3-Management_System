package group3;

import group3.DAO.EmployeeDAO;
import group3.DAO.IEmployeeDAO;
import group3.model.Employee;
import group3.model.ObjectTransfer;
import group3.repository.IEmployeeRepository;
import group3.util.BeanUtility;

import java.sql.SQLException;
import java.util.List;

public class TestObject{

    IEmployeeRepository employeeRepository = BeanUtility.getApplicationContext().getBean(IEmployeeRepository.class);

    public ObjectTransfer TestObject(Object object)
    {
        new ObjectTransfer(null, null);
        Object request = null;
        String command = null;


        if (object instanceof ObjectTransfer) {

             request = ((ObjectTransfer) object).getObject();
             command = ((ObjectTransfer) object).getCommand();
            System.out.println("Command: " + command);

            if (request instanceof Employee) {

                Employee obj = (Employee) request;

                if (command.equals("post"))
                {
                    employeeRepository.save(obj);
                }
                else if (command.equals("all"))
                {
                    System.out.println("Finding All...");
                    request = employeeRepository.findAll();
                }
            }
        }
        return  new ObjectTransfer(request, command);
    }
}
