package com.mw;

public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
        this.isRinging = false;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile turned on.");

    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.println("Now ringing to " + phoneNumber);
        } else {
            System.out.println("Phone is switched off");
        }
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering mobile phone");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("Melody ring");
        } else {
            isRinging = false;
            System.out.println("Mobile phone not on or different number");

        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }


}
