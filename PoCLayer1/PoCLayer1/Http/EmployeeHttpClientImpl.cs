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

        string employeeToJson = JsonSerializer.Serialize(employee);
        
        
        StringContent content = new(employeeToJson, Encoding.UTF8, "application/json");
        

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

    public async Task<ICollection<Employee>> GetAllEmployeesAsync()
    {
        using HttpClient client = new HttpClient();
        
        HttpResponseMessage response = await client.GetAsync("http://localhost:8081/api/employees");
        
        string responseContent = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"Error: {response.StatusCode}, {responseContent}");
        }

        ICollection<Employee> returned = JsonSerializer.Deserialize<ICollection<Employee>>(responseContent, new JsonSerializerOptions {
            PropertyNameCaseInsensitive = true
        })!;
        
        return returned;
    }

    public async Task<Employee> DeleteEmployeeByIdAsync(long id)
    {
        using HttpClient client = new HttpClient();
        
        UriBuilder builder = new UriBuilder($"http://localhost:8081/api/employees/{id}");
        
        HttpResponseMessage response = await client.DeleteAsync(builder.Uri);
        
        string responseContent = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode) {
            throw new Exception($"Error: {response.StatusCode}, {responseContent}");
        }
        
        Employee returned = JsonSerializer.Deserialize<Employee>(responseContent, new JsonSerializerOptions {
            PropertyNameCaseInsensitive = true
        })!;
  
        return returned;
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