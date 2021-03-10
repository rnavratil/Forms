package com.rnavratil.Forms.service;

import com.rnavratil.Forms.dao.Request;
import com.rnavratil.Forms.dao.RequestType;
import com.rnavratil.Forms.repository.RequestRepository;
import com.rnavratil.Forms.repository.RequestTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService{

    public RequestServiceImpl(
            RequestRepository requestRepository,
            RequestTypeRepository requestTypeRepository
    ) {
        this.requestRepository = requestRepository;
        this.requestTypeRepository = requestTypeRepository;
    }

    private final RequestRepository requestRepository;
    private final RequestTypeRepository requestTypeRepository;

    @Override
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<RequestType> getRequestTypes() {
        return requestTypeRepository.findAll();
    }
}
