package com.laurentiuspilca.ssia.controllers;

import com.laurentiuspilca.ssia.model.CreateResourceRequest;
import com.laurentiuspilca.ssia.model.GetResource200Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements ApiApi {

    @Override
    public ResponseEntity<GetResource200Response> createResource(
            @RequestBody CreateResourceRequest createResourceRequest) {
        // You should implement your own logic to create a resource here
        // For example, you might call a service that creates the resource in your database
        // For now, we will return a stubbed response

        GetResource200Response response = new GetResource200Response();
        response.setId(123); // assuming ID of the newly created resource
        response.setName(createResourceRequest.getName()); // name from the request

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GetResource200Response> getResource() {
        // You should implement your own logic to retrieve a resource here
        // For example, you might call a service that retrieves the resource from your database
        // For now, we will return a stubbed response

        GetResource200Response response = new GetResource200Response();
        response.setId(123); // assuming ID of the retrieved resource
        response.setName("Example Name"); // some name

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
