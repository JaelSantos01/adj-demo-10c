package adj.demo.server.modules.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/adj-api/test")
@CrossOrigin(origins = "*")
public class TestController {
    @GetMapping("")
    public ResponseEntity<?> getMessage() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("data", "OK");
        response.put("message", "API funcionando");
        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
