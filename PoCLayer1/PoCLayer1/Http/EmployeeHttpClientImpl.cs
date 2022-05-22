using System.Text;
using System.Text.Json;
using PoCLayer1.Model;

namespace PoCLayer1.Http;

public class EmployeeHttpClientImpl : IEmployeeHttpClient
{
    
    //Serializes, Encodes, Sends, Gets response, Checks if connected, returns what it had sent
    public async Task<Employee> AddEmployeeAsync(Employee employee)
    {
        using HttpClient client = new();

        string userToJson = JsonSerializer.Serialize(employee);
        
        
        StringContent content = new(userToJson, Encoding.UTF8, "application/json");
        

        HttpResponseMessage response = await client.PostAsync("http://localhost:8081/api/employees", content);
        
        string responseContent = await response.Content.ReadAsStringAsync();
    
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"Error: {response.StatusCode}, {responseContent}");
        }
    
        Employee returned = JsonSerializer.Deserialize<Employee>(responseContent, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return returned;
    }

    public Task<Employee> GetEmployeeByIdAsync(long id)
    {
        throw new NotImplementedException();
    }

    public Task<ICollection<Employee>> GetAllEmployeesAsync()
    {
        throw new NotImplementedException();
    }

    public Task<Employee> DeleteEmployeeByIdAsync(long id)
    {
        throw new NotImplementedException();
    }

    public Task<Employee> UpdateEmployeeAsync(Employee employee)
    {
        throw new NotImplementedException();
    }

    public Task<string> CheckEmployeeAuthState(Employee employee)
    {
        throw new NotImplementedException();
    }

    public Task<bool> CheckIfEmployeeExists(Employee employee)
    {
        throw new NotImplementedException();
    }

    public Task<Employee> GetEmployee(Employee employee)
    {
        throw new NotImplementedException();
    }
}