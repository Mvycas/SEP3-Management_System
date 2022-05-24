package group3.DAO;

import group3.model.Shift;
import group3.repository.IShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
