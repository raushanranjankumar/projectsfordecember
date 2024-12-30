package org.javaproject.dao;

import com.github.javafaker.Faker;

public interface CartDAO {
    static int generateOTP(){
        return new Faker().random().nextInt(10000,99999);
    }
}
