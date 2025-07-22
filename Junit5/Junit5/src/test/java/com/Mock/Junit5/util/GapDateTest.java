package com.Mock.Junit5.util;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class GapDateTest {


    @Autowired
    GapDate gapDate;

    @Test
    void calculateYearsOfIndependency() {

        gapDate = new GapDate();
        LocalDate today = LocalDate.now();
        String IndependencyDay = "22/02/2002";

        Period result = gapDate.calculateYearsOfIndependency(IndependencyDay);
        System.out.println(result);
        System.out.println(result.getMonths());
        System.out.println(result.getDays());
        System.out.println(result.getYears());
        Assertions.assertEquals(5, result.getMonths());
        Assertions.assertEquals(0, result.getDays());
        Assertions.assertEquals(23, result.getYears());

    }
}