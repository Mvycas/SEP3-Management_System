using System.Security.Claims;
using System.Text.Json;
using Microsoft.JSInterop;
using PoCLayer1.Http;
using PoCLayer1.Model;

namespace PoCLayer1.Authentication;

public class AuthServiceImpl : IAuthService
{
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; } = null!; // assigning to null! to suppress null warning.
    private readonly IEmployeeHttpClient employeeHttpClient;
    private readonly IJSRuntime jsRuntime;

    public AuthServiceImpl(IEmployeeHttpClient employeeHttpClient, IJSRuntime jsRuntime)
    {
        this.employeeHttpClient = employeeHttpClient;
        this.jsRuntime = jsRuntime;
    }

    public async Task LoginAsync(string username, string password)
    {
        Console.WriteLine("In LoginAsync");

        Employee newEmployee = new Employee(username, password);
        
        //bool response = await employeeHttpClient.CheckIfValidLogInAsync(new Employee(default, username, password));
        
        //Console.WriteLine("statement: " + response);
         if (await employeeHttpClient.CheckIfEmployeeExistsAsync(newEmployee))
         {
             Console.WriteLine("Valid info");
             await CacheUserAsync(newEmployee!); // Cache the user object in the browser 
        
        
             ClaimsPrincipal principal = CreateClaimsPrincipal(newEmployee); // convert user object to ClaimsPrincipal
        
             OnAuthStateChanged?.Invoke(principal); // notify interested classes in the change of authentication state
         }
         else
         {
             Console.WriteLine("Wrong Info");
         }
    }
    
    public async Task<ClaimsPrincipal> GetAuthAsync() // this method is called by the authentication framework, whenever user credentials are reguired
    {
        Employee? employee=  await GetUserFromCacheAsync(); // retrieve cached user, if any

        ClaimsPrincipal principal = CreateClaimsPrincipal(employee); // create ClaimsPrincipal

        return principal;
    }
    
    private async Task<Employee?> GetUserFromCacheAsync()
    {
        string userAsJson = await jsRuntime.InvokeAsync<string>("sessionStorage.getItem", "currentUser");
        if (string.IsNullOrEmpty(userAsJson)) return null;
        Employee employee = JsonSerializer.Deserialize<Employee>(userAsJson)!;
        return employee;
    }
    
    private static ClaimsPrincipal CreateClaimsPrincipal(Employee? employee)
    {
        if (employee != null)
        {
            ClaimsIdentity identity = ConvertUserToClaimsIdentity(employee);
            return new ClaimsPrincipal(identity);
        }

        return new ClaimsPrincipal();
    }
    
    private static ClaimsIdentity ConvertUserToClaimsIdentity(Employee employee)
    {
        // here we take the information of the User object and convert to Claims
        // this is (probably) the only method, which needs modifying for your own user type
        List<Claim> claims = new()
        {
            new Claim(ClaimTypes.Name, employee.login)
        };

        return new ClaimsIdentity(claims, "apiauth_type");
    }
    
    private async Task CacheUserAsync(Employee employee)
    {
        string serialisedData = JsonSerializer.Serialize(employee);
        await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", serialisedData);
    }
    
    private async Task ClearUserFromCacheAsync()
    {
        await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", "");
    }
}