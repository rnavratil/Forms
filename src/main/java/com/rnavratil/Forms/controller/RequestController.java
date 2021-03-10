package com.rnavratil.Forms.controller;

import com.rnavratil.Forms.dao.Request;
import com.rnavratil.Forms.dao.RequestType;
import com.rnavratil.Forms.service.RequestServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Request controller
 */
@RestController
@RequestMapping(value = "api/public", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:3000")
public class RequestController {

    public RequestController(
            RequestServiceImpl requestService
    ) {
        this.requestService = requestService;
    }

    private final RequestServiceImpl requestService;

    /**
     * Get all request types
     * @return the list of request type objects
     */
    @GetMapping("requestType")
    public List<RequestType> getRequestTypes() {
        return requestService.getRequestTypes();
    }

    /**
     * Create new request
     * @param request object with new request
     * @param result    the tool used for validation
     * @return  the map with information for adding new request or printing error message.
     */
    @PostMapping("newRequest")
    public Map<String, Object> newRequest(@Valid @RequestBody Request request, BindingResult result) {

        Map <String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            response.put("success", false);
        } else {
            Request newRequest = requestService.createRequest(request);
            response.put("success", true);
        }
        return response;
    }
}
