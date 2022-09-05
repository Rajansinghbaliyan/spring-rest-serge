package io.cherrytechnologies.springrestserge.ui.controllers.user;

import io.cherrytechnologies.springrestserge.ui.model.request.CreateUserDetailRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
public class UserControllers {

    @GetMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok("Getting users");
    }

    @PostMapping(
            path = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<String> createUser(@RequestBody CreateUserDetailRequestModel userDetails){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
    }
}
