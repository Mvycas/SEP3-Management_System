package group3.controllers;

import group3.model.Shift;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IShiftController {
    public List<Shift> getAllShifts() throws IOException, ClassNotFoundException;
    public Shift addShift(Shift shift) throws IOException, InterruptedException, ClassNotFoundException;
    public Shift deleteShift(Long userId) throws IOException, ClassNotFoundException;
}
