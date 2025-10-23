
import java.util.HashMap;

@Controller
@RequesMapping("/adj-api/test")
@CrossOrigin(origins="*")
public class TestController{
    @GetMapping("")
    public ResponseEntity<?> getMessage(){
        HashMap<String, Object> response = new HashMap<>();
        response.put("data", "OK");
        response.put("message", "API funcionando");

        return new ResponseEntity<>(
            reponse,
            HttpStatus.OK
        );
    }
}
mnc