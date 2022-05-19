package group3;

import group3.model.Employee;
import group3.model.TransferObject;
import group3.model.User;
import group3.repository.IUserRepository;
import group3.util.BeanUtility;

import java.util.List;

public class TestObject{

    IUserRepository userRepository = BeanUtility.getApplicationContext().getBean(IUserRepository.class);

    public TransferObject TestObject(Object object)
    {
        new TransferObject(null, null);
        Object request = null;
        String command = null;


        if (object instanceof TransferObject) {

             request = ((TransferObject) object).getObject();
             command = ((TransferObject) object).getCommand();
            System.out.println("Command: " + command);

            if (request instanceof User) {

                User obj = (User) request;

                if (command.equals("post"))
                {
                    userRepository.save(obj);
                }
                else if (command.equals("all"))
                {
                    System.out.println("Finding All...");
                    request = userRepository.findAll();
                }
            }
        }
        return  new TransferObject(request, command);
    }
}
