package com.Mock.Junit5.controller;

import com.Mock.Junit5.entity.Country;
import com.Mock.Junit5.entity.CountryResponse;
import com.Mock.Junit5.repository.CountryRepository;
import com.Mock.Junit5.util.GapDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class IndependencyControllerTest {

    @Autowired
    CountryResponse countryResponse;

    @Autowired
    Optional<Country> country;

    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);

    @Autowired
    GapDate gapDate = new GapDate();

    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock,gapDate);

    @BeforeEach
    void setUp() {
        Country mockCountry = new Country();
        mockCountry.setIsoCode("PT");
        mockCountry.setCountryId((long)2);
        mockCountry.setCountryIdependenceDate("2/02/2022");
        mockCountry.setCountryName("Portugal");
        mockCountry.setCountryCapital("Lisboa");

        Mockito.when(countryRepositoryMock.findCountryByIsoCode("PT")).thenReturn(mockCountry);
    }

    @Test
    void getCountryDetails() {
        ResponseEntity<CountryResponse> responseService;
        responseService = independencyController.getCountryDetails("PT");
        Assertions.assertEquals("Portugal",responseService.getBody().getCountryName());




    }

    @AfterEach
    void tearDown() {
    }


}