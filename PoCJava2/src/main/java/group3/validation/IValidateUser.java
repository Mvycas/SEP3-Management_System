package group3.validation;

import group3.model.Employee;

import java.io.IOException;

public interface IValidateUser
{
    public boolean validateUser(Object object) throws IOException, ClassNotFoundException;
}
