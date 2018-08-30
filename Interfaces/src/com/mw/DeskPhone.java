package com.mw;

public class DeskPhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;

    @Override
    public void powerOn() {
        System.out.println("Turned on.");

    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing to " + phoneNumber);
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering desk phone");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber) {
            isRinging = true;
            System.out.println("Ring ring");
        } else {
            isRinging = false;

        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
        this.isRinging=false;
    }
}
