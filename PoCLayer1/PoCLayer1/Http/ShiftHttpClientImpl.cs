using System.Text;
using System.Text.Json;
using PoCLayer1.Model;
namespace PoCLayer1.Http;

public class ShiftHttpClientImpl : IShiftHttpClient
{
    public async Task<ICollection<Shift>> GetAllShiftsAsync()
    {
        using HttpClient client = new HttpClient();
        
        HttpResponseMessage response = await client.GetAsync("http://localhost:8081/api/shifts");
        
        string responseContent = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"Error: {response.StatusCode}, {responseContent}");
        }

        ICollection<Shift> returned = JsonSerializer.Deserialize<ICollection<Shift>>(responseContent, new JsonSerializerOptions {
            PropertyNameCaseInsensitive = true
        })!;
        
        return returned;
    }

    public async Task<Shift> AddShiftAsync(Shift shift)
    {
        using HttpClient client = new();

        string shiftToJson = JsonSerializer.Serialize(shift);
        
        
        StringContent content = new(shiftToJson, Encoding.UTF8, "application/json");
        
        Console.WriteLine("TESTING SHIFT HTTP CLIENT IMPL LAYER 1: " + shift.address + " content: " + content);
        
        HttpResponseMessage response = await client.PostAsync("http://localhost:8081/api/shift", content);
        
        string responseContent = await response.Content.ReadAsStringAsync();
    
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"Error: {response.StatusCode}, {responseContent}");
        }
    
        Shift returned = JsonSerializer.Deserialize<Shift>(responseContent, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return returned;
    }

    public async Task<Shift> DeleteShiftByIdAsync(long id)
    {
        using HttpClient client = new HttpClient();
        
        UriBuilder builder = new UriBuilder($"http://localhost:8081/api/shifts/{id}");
        
        HttpResponseMessage response = await client.DeleteAsync(builder.Uri);
        
        string responseContent = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode) {
            throw new Exception($"Error: {response.StatusCode}, {responseContent}");
        }
        
        Shift returned = JsonSerializer.Deserialize<Shift>(responseContent, new JsonSerializerOptions {
            PropertyNameCaseInsensitive = true
        })!;
  
        return returned;
    }
}

