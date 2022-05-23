package group3.DAO;

import group3.model.Shift;

import java.util.List;

public interface IShiftDAO {
    public List<Shift> getAllShifts();
    public Shift addShift(Shift shift);
}
