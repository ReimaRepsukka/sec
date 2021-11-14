package repe.sec;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import repe.sec.data.Customer;
import repe.sec.data.MyCustomerReposition;
import repe.sec.data.Role;
import repe.sec.encoder.MyPasswordEncoder;


@SpringBootApplication
@RestController
public class SecApplication {

	@Autowired
	MyCustomerReposition myRepo;

	@Autowired
	MyPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(SecApplication.class, args);
	}

	@PostConstruct
	public void init(){
		myRepo.save(new Customer("reima", "repe", encoder.encode("asd1"), Role.ADMIN));
		myRepo.save(new Customer("lisa", "lis", encoder.encode("aabb"), Role.CUSTOMER));
		myRepo.save(new Customer("Jackie", "jack", encoder.encode("xxx"), Role.CUSTOMER));
	}

	@GetMapping("/public")
	public ResponseEntity<String> some() {
		return ResponseEntity.ok("This is public!");
	}

	@GetMapping("/customer")
	public ResponseEntity<String> getInfo() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		return ResponseEntity.ok("Customer is in! Welcome "+username);
	}

	@GetMapping("/admin")
	public ResponseEntity<String> setAdmin() {
		return ResponseEntity.ok("Admin is in! ");
	}
}
