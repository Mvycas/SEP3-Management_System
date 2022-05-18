using PoCLayer1.Model;

namespace PoCLayer1.Http;

public interface IEmployeeHttpClient
{
    public Task<Employee> AddEmployeeAsync(Employee employee);
    public Task<Employee> GetEmployeeByIdAsync(long id);
    public Task<ICollection<Employee>> GetAllEmployees();
    public Task<Employee> DeleteEmployeeByIdAsync(long id);
    public Task<Employee> UpdateEmployeeAsync(Employee employee);
    public Task<Boolean> CheckIfEmployeeExistsAsync(Employee employee);
}