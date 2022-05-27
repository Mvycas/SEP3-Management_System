package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.Shift;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IShiftDAO {
    public List<Shift> getAllShifts();
    public Shift addShift(Shift shift);
    public ResponseEntity<Shift> deleteShift(Long shiftId) throws ResourceNotFoundException;
}
