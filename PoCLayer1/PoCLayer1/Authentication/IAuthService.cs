using System.Security.Claims;

namespace PoCLayer1.Authentication;

public interface IAuthService
{
    public Task LoginAsync(string username, string password);
    public Task LogoutAsync();
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
    public Task<ClaimsPrincipal> GetAuthAsync();
}