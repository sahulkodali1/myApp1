package com.myApp1.Rest.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myApp1.Model.User;
import com.myApp1.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @param user
	 * @return
	 * @throws Exception
	 *             creating user through POST method
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<User> createuser(@Valid @RequestBody User user) throws Exception {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}

	/**
	 * @param userName
	 * @return
	 * @throws Exception
	 *             deletes user form by taking path variable username
	 */
	@RequestMapping(value = "{deleteuser}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteuser(@PathVariable String userName) throws Exception {
		if (!userName.contains(".com"))
			userName += ".com";

		userService.delete(userName);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	/**
	 * @param user
	 * @return
	 * @throws Exception
	 *             this method updates user and saves into repository
	 */
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public ResponseEntity<User> updateuser(@Valid @RequestBody User user) throws Exception {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
	}

	/**
	 * @param userName
	 * @return
	 * @throws Exception
	 *             this method gets the user from repository
	 */
	@RequestMapping(value = "{userdetails}", method = RequestMethod.GET)
	public ResponseEntity<User> getuserdetails(@PathVariable String userName) throws Exception {
		if (!userName.contains(".com")) {
			userName += ".com";
		}
		return new ResponseEntity<User>(userService.getDetails(userName), HttpStatus.OK);
	}
}
