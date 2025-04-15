package guru.springframework.spring6restmvc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl(){
        this.customerMap = new HashMap<>();

        Customer c1 = Customer.builder()
            .id(UUID.randomUUID())
            .customerName("Pepito Perez")
            .version(1)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        Customer c2 = Customer.builder()
            .id(UUID.randomUUID())
            .customerName("Oscar Ramirez")
            .version(1)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        Customer c3 = Customer.builder()
            .id(UUID.randomUUID())
            .customerName("John Smith")
            .version(1)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();
        
            customerMap.put(c1.getId(), c1);
            customerMap.put(c2.getId(), c2);
            customerMap.put(c3.getId(), c3);
        }

    @Override
    public List<Customer> listAllCustomers(){
            return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id){
        return customerMap.get(id);
    }
    
}
