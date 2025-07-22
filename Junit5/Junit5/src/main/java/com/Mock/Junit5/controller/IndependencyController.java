package com.Mock.Junit5.controller;


import com.Mock.Junit5.entity.Country;
import com.Mock.Junit5.entity.CountryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Mock.Junit5.repository.CountryRepository;
import com.Mock.Junit5.util.GapDate;

import java.time.Period;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class IndependencyController {

    CountryResponse countryResponse;
    Optional<Country> country;
    CountryRepository countryRepository;
    GapDate gapDate;


    public IndependencyController(CountryRepository countryRepository, GapDate gapDate) {
        this.countryRepository = countryRepository;
        this.gapDate = gapDate;
    }

    @GetMapping(path = "/{countryId}")
    public ResponseEntity<CountryResponse> getCountryDetails(@PathVariable("countryId") String countryId) {
        country = Optional.of(new Country());
        countryResponse = new CountryResponse();

        country = Optional.ofNullable(countryRepository.findCountryByIsoCode(countryId.toUpperCase()));

        if (country.isPresent()) {
            Period period = gapDate.calculateYearsOfIndependency(country.get().getCountryIdependenceDate());
            countryResponse.setCountryName(country.get().getCountryName());
            countryResponse.setCapitalName(country.get().getCountryCapital());
            countryResponse.setIndependenceDate(country.get().getCountryIdependenceDate());
            countryResponse.setDayssOfIndependency(period.getDays());
            countryResponse.setMonthsOfIndependency(period.getMonths());
            countryResponse.setYearsOfIndependency(period.getYears());
        }
        return ResponseEntity.ok(countryResponse);
    }
}
