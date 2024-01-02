package ua.nure.svyrydenko.mykolchuk.lab4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.ExecutionRequest;
import ua.nure.svyrydenko.mykolchuk.lab4.Services.DatabaseService;

@RestController
@RequestMapping("/execute")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping
    public ResponseEntity<Object> executeFunctionProcedure(@RequestBody ExecutionRequest request) {
        try {
            Object result = databaseService.execute(request.getOperation(), request.getParameters());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}


