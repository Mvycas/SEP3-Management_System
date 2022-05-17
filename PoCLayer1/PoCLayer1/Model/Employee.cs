namespace PoCLayer1.Model;

public class Employee
{
    public Employee()
    {
    }

    public Employee(string login, string password)
    {
        this.login = login;
        this.password = password;
    }

    public Employee( long id, string login, string password)
    {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    
    
    public long  id { get; set; }
    public string login { get; set; }
    public string password { get; set; }

}