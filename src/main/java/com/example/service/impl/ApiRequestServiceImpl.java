package com.example.service.impl;

import com.example.dao.ApiRequestDao;
import com.example.model.ApiRequest;
import com.example.service.ApiRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private ApiRequestDao apiRequestDao;

    @Override
    public void create(ApiRequest apiRequest) {
        apiRequestDao.create(apiRequest);
    }

    @Override
    public Date getRequestTime(long id) {
        return apiRequestDao.getApiRequestById(id).getRequestTime();
    }
}
