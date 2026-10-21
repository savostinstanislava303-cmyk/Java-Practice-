package practice2;

public class practice04 {
    public static void main() {
        int userAge = 17;
        boolean isAdult = userAge >= 18;
        System.out.println("Вік: "+ userAge  + ". Чи є повнолітнім:" + isAdult);
        System.out.println();
        int x = 15;
        int y =20;
        System.out.println("Чи рівні числа: " + ( x==y ));
        System.out.println("Чи не рівні: " + ( x!=y ));
        System.out.println("Чи x більше за y: " + (x >y));
        System.out.println();
        int speed = 75;
        boolean isSafeSpeed=(speed >= 20) && (speed <= 80);
        System.out.println("Чи знаходиться швидкість у безпечному міському діапазоні: " + isSafeSpeed);
        System.out.println();
        int personAge = 70;
        boolean hasFreePass = (personAge < 7) || (personAge >= 65);
        System.out.println("Вік: " + personAge + ". Право на безкоштовний проїзд: " + hasFreePass);
        System.out.println();
        boolean isDoorLocked = true;
        boolean canEnter = !isDoorLocked;
        System.out.println("Двері зачинені: " + isDoorLocked);
        System.out.println("Чи можна увійти: " + canEnter);
        System.out.println();
        int number = 30;
        boolean isDivisibleByBoth = (number % 3 ==0) && (number % 5 ==0);
        System.out.println("Число " + number + " ділиться на 3 і 5: " + isDivisibleByBoth);
        number = 25;
        isDivisibleByBoth = (number % 3 ==0) && (number % 5 ==0);
        System.out.println("Число " + number + " ділиться на 3 і 5: " + isDivisibleByBoth);
        System.out.println();
        boolean hasPassword = true;
        boolean hasSmsCode = true;
        boolean isAccountBlocked = false;
        boolean canLogin = hasPassword && hasSmsCode && !isAccountBlocked;
        System.out.println("Чи можна увійти в систему: " + canLogin);
        System.out.println();
        int year = 2024;
        boolean isLeapYear = (year % 4 ==0 && year % 100 !=0) || (year % 400 == 0);
        System.out.println("Рік: " + year + " є високосним: " + isLeapYear);



    }
}
