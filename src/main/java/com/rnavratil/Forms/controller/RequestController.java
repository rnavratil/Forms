package com.rnavratil.Forms.controller;

import com.rnavratil.Forms.dao.CodelistCrate;
import com.rnavratil.Forms.dao.Request;
import com.rnavratil.Forms.dao.RequestType;
import com.rnavratil.Forms.service.RequestServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
    public List<CodelistCrate> getRequestTypes() {
       return createCrate(requestService.getRequestTypes());
    }

    /**
     * Create new request
     * @param request object with new request
     * @return  the map with information for adding new request or printing error message.
     */
    @PostMapping("newRequest")
    public Map<String, Object> newRequest(@Valid @RequestBody Request request) {

        Map <String, Object> response = new HashMap<>();
        response = validateRequest(request);
        if (response.get("success").equals(true)) {
            requestService.createRequest(request);
        }
        return response;
    }

    /**
     * Create general class for frontend elements
     * @param requestTypes All types of request.
     * @return  the map with values and names
     */
    private List<CodelistCrate> createCrate(List<RequestType> requestTypes) {
        List<CodelistCrate> codelistCrates = new ArrayList<>();
        for (RequestType requestType: requestTypes) {
            CodelistCrate codelistCrate = new CodelistCrate();
            codelistCrate.setLabel(requestType.getName());
            codelistCrate.setValue(requestType.getId());
            codelistCrates.add(codelistCrate);
        }
        return codelistCrates;
    }

    /**
     * Validation request data
     * @param request The request object
     * @return the map with result.
     */
    private Map<String, Object> validateRequest(Request request) {


        Map <String, Object> response = new HashMap<>();
        response.put("success", true);

        //name
        if (request.getName() == null || !Pattern.matches("^[a-zA-Z]{1,30}$", request.getName())) {
            response.put("success", false);
        }

        //surname
        if (request.getSurname() == null || !Pattern.matches("^[a-zA-Z]{1,30}$", request.getSurname())) {
            response.put("success", false);
        }

        //policy number
        if (request.getPolicyNumber() == null || !Pattern.matches("^[a-zA-Z0-9]{1,30}$", request.getPolicyNumber())) {
            response.put("success", false);
        }

        //note
        if (request.getNote() == null || request.getNote().isEmpty() || request.getNote().length() > 5000) {
            response.put("success", false);
        }

        return response;
    }
}
