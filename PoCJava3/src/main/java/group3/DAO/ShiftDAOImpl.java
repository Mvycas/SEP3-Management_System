package group3.DAO;

import group3.exception.ResourceNotFoundException;
import group3.model.Shift;
import group3.repository.IShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import java.util.List;


@Controller
public class ShiftDAOImpl implements IShiftDAO{

    @Autowired
    private IShiftRepository shiftRepository;

    @Override
    public List<Shift> getAllShifts() {
        return null;
    }

    @Override
    public Shift addShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public ResponseEntity<Shift> deleteShift(Long shiftId) throws ResourceNotFoundException
    {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found with this id" + shiftId));
        this.shiftRepository.delete(shift);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
