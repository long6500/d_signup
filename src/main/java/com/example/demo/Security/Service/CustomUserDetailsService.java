package com.example.demo.Security.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new CustomUserDetails(employee);
    }
}
