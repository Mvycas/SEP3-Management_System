namespace PoCLayer1.Model;

public class Employee : User
{

    public Employee(long id, string username, string password, string firstName, string lastName,
        string email, string phoneNumber, string authLevel, string address, double hours) 
        : base(id, username, password, firstName, lastName, email, phoneNumber, authLevel)
    {
        Address = address;
        Hours = hours;
        AuthLevel = "Employee";
    }


    public string Address { get; set; }
    public double Hours { get; set; }
    
}