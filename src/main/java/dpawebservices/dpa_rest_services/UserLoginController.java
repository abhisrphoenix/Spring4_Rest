package dpawebservices.dpa_rest_services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dpawebservices.pojo.User;

@RestController
public class UserLoginController { 
	@RequestMapping(value = "/authUser", method = RequestMethod.POST)
	private ResponseEntity<User> validateUser(@RequestBody User user) {

		System.out.println("--" + user.getUsername());
		System.out.println("--" + user.getPass());

		return new ResponseEntity("Valid", HttpStatus.CREATED);

	}

}
