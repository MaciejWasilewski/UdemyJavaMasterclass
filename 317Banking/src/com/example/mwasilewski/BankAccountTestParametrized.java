package com.example.mwasilewski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTestParametrized {
    private BankAccount account;


    @BeforeEach
    public void setup()
    {
        account=new BankAccount("Tim", "Buchalka",1000,BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @ParameterizedTest
    @MethodSource("argsForDepositTest")
    void testParamDepost(double amount, boolean branch, double expBalance)
    {
        assertEquals(expBalance,account.deposit(amount, branch),0);
    }

    public static Stream<Arguments> argsForDepositTest()
    {
        Random random=new Random();
        return random.doubles(100).map(d->d*1000.0).map(d->Math.floor(d*100)/100).mapToObj(d->Arguments.of(d,true,
                d+1000.0));
//        return Stream.of(
//                Arguments.of(100,true, 1100),
//                Arguments.of(200,true, 1200),
//                Arguments.of(325.14,true, 1325.14),
//                Arguments.of(489.33,true, 1489.33),
//                Arguments.of(1000,true, 2000)
//        );
    }
}
