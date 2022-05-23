using PoCLayer1.Model;

namespace PoCLayer1.Http;

public interface IShiftHttpClient
{
    public Task<ICollection<Shift>> GetAllShiftsAsync();
    public Task<Shift> AddShiftAsync(Shift shift);
}