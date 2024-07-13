package com.fd.food.restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {
	@Autowired
    private RestaurantService restaurantService;
	
	@GetMapping(value = "/api/restaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(value = "/api/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        return restaurant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/api/restaurant")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
    	Restaurant addedRestaurant = restaurantService.saveOrUpdateRestaurant(restaurant);
        return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/restaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long id,
                                                       @RequestBody Restaurant restaurant) {
        if (!restaurantService.getRestaurantById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        restaurant.setId(id);
        Restaurant updatedRestaurant = restaurantService.saveOrUpdateRestaurant(restaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/restaurant/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) {
        if (!restaurantService.getRestaurantById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

