package group3.controllers;

import group3.InitializeConnection;
import group3.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ShiftControllerImpl implements IShiftController {

    @Autowired
    InitializeConnection initializeConnection;

    @GetMapping("/shifts")
    public List<Shift> getAllShifts() throws IOException, ClassNotFoundException {
        System.out.println("Getting All");
        Shift shift = new Shift();
        return (List<Shift>) initializeConnection.sendTransferObject("all", shift);
    }

    @PostMapping("shift")
    public Shift addShift(@RequestBody Shift shift) throws IOException, ClassNotFoundException {
        System.out.println("Posting...");
        Shift newShift = (Shift) initializeConnection.sendTransferObject("post", shift);
        System.out.println(shift.getDescription() + " layer2 shift controller impl:  " + shift.getAddress());
        return newShift;
    }

    @DeleteMapping("/shifts/{id}")
    public Shift deleteShift(@PathVariable("id") Long shiftId) throws IOException, ClassNotFoundException {
        System.out.println("Deleting...");
        Shift shift = (Shift) initializeConnection.sendTransferObject("delete", new Shift(shiftId));
        return shift;
    }
}
