package com.Mock.Junit5.repository;

import com.Mock.Junit5.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {

    Country findCountryByIsoCode(String isoCode);
}
