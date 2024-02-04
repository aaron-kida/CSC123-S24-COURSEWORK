// Aaron Hoang (ahoang14@toromail.csudh.edu)

import java.util.Scanner;

public class Gravity {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the initial position (height) in meters from where the object was dropped: ");
        double initialPosition = keyboard.nextDouble();
        
        System.out.print("Enter the observation time in seconds: ");
        double time = keyboard.nextDouble();

        // gravity 
        double acceleration = -9.81;

        // Initial velocity starts at 0 since the object was dropped from rest
        double initialVelocity = 0;

        // Calculate the distance fallen using the formula x(t) = 0.5 * a * t^2 + vi * t + xi
        double distanceFallen = 0.5 * acceleration * Math.pow(time, 2) + initialVelocity * time + initialPosition;

        // Calculate the distance from the ground at the given time
        double distanceFromGround = initialPosition - distanceFallen;


        System.out.println("The object was dropped from " + initialPosition + " meters and has fallen " + distanceFallen + " meters in " + time + " seconds.");
        System.out.println("The distance of the object from the ground now is " + distanceFromGround);

        keyboard.close();
    }
}

