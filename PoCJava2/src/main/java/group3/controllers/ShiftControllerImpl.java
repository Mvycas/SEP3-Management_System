package group3.controllers;

import group3.InitializeConnection;
import group3.model.Shift;
import group3.model.User;
import group3.validation.IValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShiftControllerImpl implements IShiftController {

    @Autowired
    InitializeConnection initializeConnection;

    @GetMapping("/shifts")
    public List<Shift> getAllShifts() throws IOException, ClassNotFoundException {
        System.out.println("Getting All");
        Shift shift = new Shift();
        List<Shift> allShifts = (List<Shift>) initializeConnection.sendTransferObject("all", shift);
        return allShifts;
    }

    @PostMapping("shift")
    public Shift addShift(Shift shift) throws IOException, InterruptedException, ClassNotFoundException {
        System.out.println("Posting...");
        Shift newShift = (Shift) initializeConnection.sendTransferObject("post", shift);
        System.out.println(shift.getDescription());
        return newShift;
    }
}
