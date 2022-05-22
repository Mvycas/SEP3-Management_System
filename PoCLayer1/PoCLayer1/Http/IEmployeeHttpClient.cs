using PoCLayer1.Model;

namespace PoCLayer1.Http;

public interface IEmployeeHttpClient
{
    public Task<Employee> AddEmployeeAsync(Employee employee);
    public Task<Employee> GetEmployeeByIdAsync(long id);
    public Task<ICollection<Employee>> GetAllEmployeesAsync();
    public Task<Employee> DeleteEmployeeByIdAsync(long id);
    public Task<Employee> UpdateEmployeeAsync(Employee employee);
    public Task<string> CheckEmployeeAuthState(Employee employee);
    public Task<bool> CheckIfEmployeeExists(Employee employee);
    public Task<Employee> GetEmployee(Employee employee);
}