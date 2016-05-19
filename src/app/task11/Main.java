package app.task11;

/**
 * Created by alexander on 17.05.16.
 */
public class Main {

    public static void main(String[] args) {
        //Create new ball
        Product ball = new Product("ball", 10, 500);
        //Set its date of expiration o check if it can be sold
        ball.setDateOfExpiration(2016, 07, 06);
        //Create new ball with the same date of expiration to check if they are equals
        Product ball2 = new Product("ball", 10, 500);
        ball2.setDateOfExpiration(2016, 07, 06);
        //Create new ball without parameters
        Product ball3 = new Product();
        Product unknown = new Product();
        //Check is methods work correctly
        System.out.println(ball.canBeSold());
        System.out.println("you can buy 400 balls for " + ball.sellValue(400));
        //Check if hashcode() counts correctly
        System.out.println("ball hashcode " + ball.hashCode());
        System.out.println("ball2 hashcode " + ball2.hashCode());
        System.out.println("ball3 hashcode " + ball3.hashCode());
        //Check if balls are equals
        System.out.println("ball and ball2 are equals " + ball.equals(ball2));
        System.out.println("ball and ball3 are equals " + ball.equals(ball3));
        System.out.println("ball2 and ball3 are equals " + ball2.equals(ball3));
        System.out.println("Products with no parameters are equals " + ball3.equals(unknown));
    }

}
