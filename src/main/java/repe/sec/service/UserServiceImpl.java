package repe.sec.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import repe.sec.data.Customer;
import repe.sec.data.MyCustomerReposition;

 @Service
public class UserServiceImpl implements UserDetailsService{

    @Autowired
    MyCustomerReposition customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepo.findById(username).get();

        if(customer == null){
            throw new UsernameNotFoundException("User not in database");
        }else{
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getRole().toString()));
            return new User(username,customer.getPassword(), authorities);
        }
    }
    
}
