package com.consultnet.app.phonevalidator.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.consultnet.app.phonevalidator.model.Phone;


@Transactional
@Repository
public interface PhoneRespository extends PagingAndSortingRepository<Phone,Integer> {

}
