package com.javatpoint.springbootexample.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.springbootexample.CustomisedException.ResourceNotFoundException;
import com.javatpoint.springbootexample.Model.Restrant;
import com.javatpoint.springbootexample.Repos.RestaurentRepo;

@RestController
public class RestaurentController {
	
	@Autowired
	private RestaurentRepo restaurentRepo;
	
	@PostMapping("/saveResturentDetails")
	public void saveResturentDetails(@RequestBody Restrant restaurentDetails) {
		restaurentRepo.save(restaurentDetails);
	}
	
	@GetMapping("/getResturentDetails")
	public List<Restrant> getRestaruentDetails() {
		return restaurentRepo.findAll();
	}
	
	@PutMapping("/updateRestaruent/{id}")
	public Restrant updateNote(@PathVariable(value = "id") Long restaurentId,
	                                        @Valid @RequestBody Restrant resturentDetails) {

		Restrant resturant = restaurentRepo.findById(restaurentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restaruent", "id", restaurentId));

		resturant.setRestaurentName(resturentDetails.getRestaurentName());
		resturant.setRestaurentAddress(resturentDetails.getRestaurentAddress());

	    Restrant updatedNote = restaurentRepo.save(resturant);
	    return updatedNote;
	}
	
	@DeleteMapping("/deleteRestaurent/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long restaurentId) {
		Restrant note = restaurentRepo.findById(restaurentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restrant", "id", restaurentId));

		restaurentRepo.delete(note);

	    return ResponseEntity.ok().build();
	}
	

}
