namespace PoCLayer1.Model;

public class User
{
    protected User(long id, string username, string password, string firstName, string lastName, string? email, string? phoneNumber, string authLevel)
    {
        Id = id;
        Username = username;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        AuthLevel = authLevel;
    }
    
    public long Id { get; set; }
    public string Username { get; set; }
    public string Password { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public string Email { get; set; }
    public string PhoneNumber { get; set; }
    public string AuthLevel { get; set; }
    
}