package com.example.service;

import com.example.model.ApiRequest;

import java.util.Date;

public interface ApiRequestService {
    void create(ApiRequest apiRequest);

    Date getRequestTime(long id);
}
