package com.rnavratil.Forms.service;

import com.rnavratil.Forms.dao.Request;
import com.rnavratil.Forms.dao.RequestType;

import java.util.List;

/**
 * Service for Request
 */
public interface RequestService {

    /**
     * Create new request
     * @param request  the object with new request
     * @return  the object of request
     */
    Request createRequest(Request request);

    /**
     * Get all request types
     * @return  the list of request type objects
     */
    List<RequestType> getRequestTypes();
}
