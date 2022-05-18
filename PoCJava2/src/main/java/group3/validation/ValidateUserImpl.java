package group3.validation;

import group3.InitializeConnection;
import group3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ValidateUserImpl implements IValidateUser {

    @Autowired
    InitializeConnection initializeConnection;

    @Override
    public boolean validateUser(Object object) throws IOException, ClassNotFoundException
    {

        if(object instanceof Employee)
        {
            System.out.println("Is Employee" + ((Employee) object).getLogin());
            Employee employee = (Employee) object;

            List<Employee> allEmployees = (List<Employee>) initializeConnection.getReceivedObject("all", object);

            boolean match = allEmployees.stream().filter(o -> o.getLogin().equals(((Employee) object).getLogin()) && o.getPassword().equals(((Employee) object).getPassword())).findFirst().isPresent();

            if (match)
            {
                System.out.println("Does contain login and password returning true...");
                return true;
            }
            else
            {
                System.out.println("Does not contain, returning false");
                return false;
            }
        }
        else
        {
            System.out.println("Returning false either way");
            return false;
        }

    }

}
