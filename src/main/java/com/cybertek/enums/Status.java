package com.cybertek.enums;

public enum Status {

    //different statuses of the Project: OPEN, IN PROGRESS, UAT TEST, COMPLETE

    OPEN("Open"),IN_PROGRESS("In Progress"),UAT_TEST("UAT Testing"),COMPLETE("Completed");

    private final String value;

    private Status(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
