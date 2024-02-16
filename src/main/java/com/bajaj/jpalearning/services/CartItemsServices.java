package com.bajaj.jpalearning.services;

import com.bajaj.jpalearning.exceptions.EntityAlreadyExistsException;
import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.models.CartItems;
import com.bajaj.jpalearning.models.Customer;
import com.bajaj.jpalearning.models.Product;
import com.bajaj.jpalearning.repositories.CartItemsRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemsServices {
    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    ProductServices productServices;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Object create(CartItems cartItems) {

        Optional<Product> productOptional = productRepository.findById(cartItems.getProduct().getId());
        Optional<Customer> customerOptional = customerRepository.findById(cartItems.getCustomer().getId());
        if (!productOptional.isEmpty() && !customerOptional.isEmpty() && cartItems.getQuantity()>0) {
            CartItems newItems = cartItemsRepository.save(cartItems);
            return newItems;
        }
        throw new EntityNotFoundException("Product or Customer with the given Id does not Exist");
    }

    public List<CartItems> getAll() {
        return cartItemsRepository.findAll();
    }

    public CartItems get(Long id) {
        Optional<CartItems> customerOptional = cartItemsRepository.findById(id);
        if (customerOptional.isPresent()) {
            CartItems cartItems = customerOptional.get();
            return cartItems;
        }
        throw new EntityNotFoundException("Cart Item is not found for this id");
    }

    //fetch by customer_id
    public List<CartItems> getByCustomerId(Long id) {
        Optional<List<CartItems>> customerOptional = cartItemsRepository.findByCustomerId(id);

        if (customerOptional.isPresent()) {
            List<CartItems> cartItems = customerOptional.get();
            return cartItems;
        }
        throw new EntityNotFoundException("Cart Item is not found for this id");
    }


    public List<Product> getCustomerCart(Long id){

        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            List<CartItems> cartItems = cartItemsRepository.findByCustomer(customerOptional.get());
            if(cartItems.size()>0){
                List<Product> products = cartItems.stream().map((cartItems1->cartItems1.getProduct())).toList();
                return products;
            }
        }
        throw new EntityNotFoundException("Cart Item is not found");
    }

}
