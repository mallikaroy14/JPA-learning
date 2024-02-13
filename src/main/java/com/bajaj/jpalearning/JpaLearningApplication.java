package com.bajaj.jpalearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class JpaLearningApplication {
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaLearningApplication.class, args);

	}

	// ... it convert into  array run(1,2,3,4)
	// Entity
	//Repository -> functions
//	@Override
//	public void run(String... args) throws Exception {


		// Insert operation

        /*
        Customer customer1 = new Customer("Radhika", 22, "radhika@gmail.com", "radhika");
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Sampada", 23, "sampada@gmail.com", "sampada");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Akash", 24, "akash@gmail.com", "akash");
        customerRepository.save(customer3);
         */

		// Select
/*
        List<Customer> customerList = customerRepository.findAll();
        customerList.forEach(
                (customer -> {
                    System.out.println("Customers" + customer);
                }));

 */
		// Where - select operation for single element based on id
        /*
         Optional<Customer> customer = customerRepository.findById(1L); // If customer with that id is not present hence take it as Optional

         if(customer.isPresent()) {
             System.out.println(customer.get());
        } else {
             System.out.println("Customer not found");
         }
         */

		// Find customer with Email id

        /*
        Optional<Customer> customer1 = customerRepository.findByEmailId("radhika@gmail.com"); // If customer with that id is not present hence take it as Optional

        if(customer1.isPresent()) {
            System.out.println(customer1.get());
        } else {
            System.out.println("Customer not found");
        }

         */
		// Find customer with Email id and age
        /*
        Optional<Customer> customer2 = customerRepository.findByEmailIdAndAge("radhika@gmail.com", 22); // If customer with that id is not present hence take it as Optional

        if(customer2.isPresent()) {
            System.out.println(customer2.get());
        } else {
            System.out.println("Customer not found");
        }
        */


		// Find customer with Email id or age

       /*
        List<Customer> customerList = customerRepository.findByEmailIdOrAge("malika@gmail.com", 22); // If customer with that id is not present hence take it as Optional
        customerList.forEach(
                (customer -> {
                    System.out.println("Customers" + customer);
                }));
        */

        /*
        List<Customer> customerList = customerRepository.findCustomers("Radhika", 22); // If customer with that id is not present hence take it as Optional
        customerList.forEach(
                (customer -> {
                    System.out.println("Customers" + customer);
                }));
         */

		// Finding and Updating
/*
        Optional<Customer> customer = customerRepository.findById(2L);

        if (customer.isPresent()) {
            Customer c = customer.get();
            c.setEmailId("saurabh@gmail.com");
            customerRepository.save(c);
            System.out.println("c");
        } else {
            System.out.println("Customer not found");
        }

 */

//	}


//	@GetMapping("/") // here / means base address
//	public String dummyEndPoint() {
//		return "Hello World !!!";
//	}
}