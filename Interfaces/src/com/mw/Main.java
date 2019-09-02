package com.mw;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ITelephone timsPhone;
        timsPhone = new DeskPhone(1234);
        timsPhone.powerOn();
        timsPhone.callPhone(1234);
        timsPhone.answer();
        timsPhone=new MobilePhone(122242);
        timsPhone.powerOn();
        timsPhone.callPhone(122242);
        timsPhone.answer();

    }
}
