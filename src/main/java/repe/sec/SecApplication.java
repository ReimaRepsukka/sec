package repe.sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecApplication.class, args);
	}

	@GetMapping("/public")
	public ResponseEntity<String> some() {
		return ResponseEntity.ok("This is public!");
	}

	@GetMapping("/customer")
	public ResponseEntity<String> getInfo() {
		return ResponseEntity.ok("Customer is in!");
	}

	@GetMapping("/admin")
	public ResponseEntity<String> setAdmin() {
		return ResponseEntity.ok("Admin is in! ");
	}
}
