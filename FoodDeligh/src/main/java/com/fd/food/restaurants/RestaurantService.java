package com.fd.food.restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
	
	@Autowired
    private RestaurantRepo restaurantRepository;
	
	 public List<Restaurant> getAllRestaurants() {
	        return restaurantRepository.findAll();
	    }
	 
	  public Optional<Restaurant> getRestaurantById(Long id) {
	        return restaurantRepository.findById(id);
	    }

	    public Restaurant saveOrUpdateRestaurant(Restaurant restaurant) {
	        return restaurantRepository.save(restaurant);
	    }

	    public void deleteRestaurant(Long id) {
	        restaurantRepository.deleteById(id);
	    }
	

}


