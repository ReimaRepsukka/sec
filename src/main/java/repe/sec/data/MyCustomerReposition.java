package repe.sec.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MyCustomerReposition extends JpaRepository<Customer, String> {
}
