package com.company;

/**
 *  The class contains information about the person.
 *  @version 1.0 17.03.2019
 *  @author Sergey Kotov
 */

public class People {
    private static final int FEMALE_RETIREMENT_AGE = 60;
    private static final int MALE_RETIREMENT_AGE = 65;
    private String name;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String gender;
    private int age;
    private int numberOfQueue;

    /**The constructor create person with @param name, @param gender, @param age.*/
    public People(final String name, final String gender, final int age) {
        String[] fullName = name.split(" ");
        this.name = name;
        this.firstName = fullName[0];
        if (fullName.length > 1) {
            this.lastName = fullName[1];
            if (fullName.length > 2) {
                this.patronymic = fullName[2];
            }
        }
        this.gender = gender;
        this.age = age;
    }

    /**The method returns @param name.*/
    public final String getName() {
        return name;
    }

    /**The method returns @param firstName.*/
    public final String getFirstName() {
        return firstName;
    }

    /**The method returns @param lastName.*/
    public final String getLastName() {
        return lastName;
    }

    /**The method returns @param patronymic.*/
    public final String getPatronymic() {
        return patronymic;
    }

    /**The method returns @param gender.*/
    public final String getGender() {
        return gender;
    }

    /**The method returns @param age.*/
    public final int getAge() {
        return age;
    }

    /**The method sets number in queue.*/
    public final void setNumberOfQueque(final int numberInQueue) {
        this.numberOfQueue = numberInQueue;
    }

    /**The method returns @param numberOfQueue.*/
    public final int getNumberOfQueque() {
        return numberOfQueue;
    }

    /**The method returns information about whether the person retired.*/
    public final boolean isPensioner() {
        if (gender.equals("Женский")) {
            return age > FEMALE_RETIREMENT_AGE;
        } else {
            return age > MALE_RETIREMENT_AGE;
        }
    }

}
