package edu.cnm.deepdive.customerdata;

import edu.cnm.deepdive.customerdata.entity.Customer;
import edu.cnm.deepdive.customerdata.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerdataApplicationTests {

  @Autowired
  CustomerRepository repository;

  @Test
  void contextLoads() {
  }

  @Test
  void testCreate() {
    Customer customer = new Customer();
    customer.setId(1);
    customer.setName("Franky Oceanus");
    customer.setEmail("grog@grog.org");
    repository.save(customer);

    customer.setId(2);
    customer.setName("XXX Antius");
    customer.setEmail("under@gold.dev");
    repository.save(customer);
  }

  @Test
  void testRead() {
    Customer customer = repository.findById(1).get();
    Assert.assertNotNull(customer);
    Assert.assertEquals(customer.getName(),"Franky Oceanus");
    System.out.println(">>>>>>>>>>>>>>>>>>>>> " + customer.getEmail());
  }


  @Test
  void testUpdate() {
    Customer customer = repository.findById(1).get();
    customer.setEmail("grogy@grog.org");
    repository.save(customer);
  }

  @Test
  void testDelete(){
    if(repository.existsById(1)){
      System.out.println("Deleting a product");
      repository.deleteById(1);
    }
  }

}
