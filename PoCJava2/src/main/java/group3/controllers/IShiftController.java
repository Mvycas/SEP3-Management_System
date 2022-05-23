package group3.controllers;

import group3.model.Shift;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface IShiftController {
    public List<Shift> getAllShifts() throws IOException, ClassNotFoundException;
    public Shift addShift(Shift shift) throws IOException, InterruptedException, ClassNotFoundException;
}
