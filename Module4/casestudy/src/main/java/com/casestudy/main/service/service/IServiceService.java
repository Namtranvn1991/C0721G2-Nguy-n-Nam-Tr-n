package com.casestudy.main.service.service;

import com.casestudy.main.model.service.Service;
import com.casestudy.main.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService extends IGeneralService<Service> {
    Page<Service> findAll(int pageNo, int pageSize, String sortField, String sortDirection);
}
