package edu.cnm.deepdive.customerdata.repos;


import edu.cnm.deepdive.customerdata.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
