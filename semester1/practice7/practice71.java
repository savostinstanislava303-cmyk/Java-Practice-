package practice7;
import java.util.Locale;
public class practice71 {
 public static void main (String[] args){
     java.util.Scanner sc = new java.util.Scanner(System.in);
     while (true){
          System.out.print("\nПрактична №7. Введіть номер завдання 1-40 (0 — вихід): ");
          if(!sc.hasNextInt()){
              System.out.println("Введіть число(1-40): ");
              sc.next();
              continue;
          }
          int n=sc.nextInt();
          if(n==0)break;
          switch (n){
               case 1 -> task1();
               case 2 -> task2();
               case 3 -> task3();
               case 4 -> task4();
                case 5 -> task5();
                 case 6 -> task6();
                 case 7 -> task7();
                 case 8 -> task8();
                 case 9 -> task9();
                 case 10 -> task10();
                 case 11 -> task11();
                 case 12 -> task12();
                 case 13 -> task13();
                 case 14 -> task14();
                 case 15 -> task15();
                 case 16 -> task16();
                   case 17 -> task17();
                    case 18 -> task18();
                     case 19 -> task19();
                      case 20 -> task20();
                       case 21 -> task21();
                      case 22 -> task22();
                     case 23 -> task23();
                     case 24 -> task24();
                     case 25 -> task25();
                     case 26 -> task26();
                     case 27 -> task27();
                     case 28 -> task28();
                     case 29 -> task29();
                     case 30 -> task30();
                     case 31 -> task31();
                     case 32 -> task32();
                     case 33 -> task33();
                     case 34 -> task34();
                     case 35 -> task35();
                      case 36 -> task36();
                     case 37 -> task37();
                     case 38 -> task38();
                     case 39 -> task39();
                     case 40 -> task40();


                 default -> System.out.println("Номер має бути від 1 до 40.");
            }
        }
              sc.close();
          }
          static class Book{
         private final String title;
          private final String author;
          private final int year;
          private double price;
           Book() { this("Невідомо", "Невідомий", 2000, 0.0); }
        Book(String title, String author, int year, double price) {
            this.title = title;
            this.author = author;
            this.year = year < 0 ? 2000 : year;
            this.price = price < 0 ? 0.0 : price;
        }
        void printInfo() { System.out.printf("%s — %s, %d р., %.2f грн%n", title, author, year, price); }
    }
      static void task1() {
          new Book().printInfo();
          new Book("Макова Війна", "Ребекка Кван", 2018, 850).printInfo();
      }
       static class Student {
        private final String name;
        private final int age;
        private double gpa;
        Student(String name, int age, double gpa) {
            this.name = name; this.age = age < 15 || age > 80 ? 18 : age;
            this.gpa = gpa < 0 || gpa > 5 ? 0 : gpa;
        }
        boolean isHonorStudent() { return gpa >= 4.5; }
        void printStudent() { System.out.printf("%s, вік: %d, бал: %.2f — %s%n", name, age, gpa, isHonorStudent() ? "Відмінник" : "Звичайний студент"); }
    }
        static void task2() {
        new Student("Станіслава",17,4.8).printStudent();
        new Student("Олег",17,8).printStudent();
    }
       static class BankAccount {
        private final String accountNumber;
           private final String ownerName;
        private double balance;
        BankAccount(String n, String o, double b) {
            accountNumber=n; ownerName=o; balance=Math.max(0,b);
        }
        void deposit(double amount) {
            if (amount > 0) balance += amount;
        }
        boolean withdraw(double amount) {
            if (amount <= 0 || amount > balance) return false; balance -= amount; return true;
        }
        void printAccount() {
            System.out.printf("%s | %s | %.2f грн%n", accountNumber, ownerName, balance);
        }
    }
    static void task3() {
        BankAccount account=new BankAccount("UA001","Станіслава",1000);
        account.deposit(200);
        account.withdraw(1500);
        account.printAccount();
    }
       static class Point2D {
        private double x,y;
        Point2D() {
            this(0,0);
        }
        Point2D(double x,double y) {
            this.x=x; this.y=y;
        }
       public double distanceToOrigin() {
            return Math.hypot(x,y);
        }
       public double distanceTo(double tx,double ty) {
            return Math.hypot(x-tx,y-ty);
        }
       public void printPoint() {
            System.out.printf(Locale.US,"Point(%.2f; %.2f)%n",x,y);
        }
    }
     static void task4() {
        Point2D point=new Point2D(3,4);point.printPoint();System.out.println("Відстань: "+point.distanceToOrigin());
    }
      static class Product {
        private final String name;
          private final String category; private double price;
        private final int quantity;
        Product(String n,double p,int q,String c) {
            name=n;
            price=Math.max(0,p);
            quantity=Math.max(0,q);
            category=c;
        }
       public double getTotalValue() {
            return price*quantity;
        }
        public void applyDiscount(double percent) {
            if(percent>=0 && percent<=100) price *= 1-percent/100;
        }
        public void printProduct() {
            System.out.printf("%s (%s): %.2f грн x %d = %.2f грн%n",name,category,price,quantity,getTotalValue());
        }
    }
       static void task5() {
        Product product=new Product("Чай",100,3,"Напої");
        product.applyDiscount(20);
        product.printProduct();
    }
       static class Time {
        private int hours,minutes,seconds;
        Time(int h,int m,int s) {
            hours=h>=0&&h<=23?h:0; minutes=m>=0&&m<=59?m:0; seconds=s>=0&&s<=59?s:0;
        }
        public void tick() {
            if(++seconds==60){seconds=0;if(++minutes==60){minutes=0;hours=(hours+1)%24;}}
        }
        public String toUniversalString() {
            return String.format("%02d:%02d:%02d",hours,minutes,seconds);
        }
        public String toStandardString() {
            return String.format("%d:%02d:%02d %s",hours%12==0?12:hours%12,minutes,seconds,hours<12?"AM":"PM");
        }
    }
      static void task6() {
        Time time=new Time(23,59,59);
        System.out.println(time.toUniversalString());
        time.tick();
        System.out.println(time.toUniversalString());
    }
       static class Rectangle {
        private final double width;
           private final double height;
        Rectangle(){
            this(1,1);
        }
        Rectangle(double size){
            this(size,size);
        }
        Rectangle(double w,double h){width=Math.max(0,w);
            height=Math.max(0,h);
        }
        public double getArea(){
            return width*height;
        }
        public double getPerimeter(){return 2*(width+height);
        }
        public boolean isSquare(){
            return Double.compare(width,height)==0;
        }
    }
      static void task7() {
        Rectangle rect=new Rectangle(5,7);
        System.out.println("Площа: "+rect.getArea()+", периметр: "+rect.getPerimeter());
    }
     static class Employee {
        private final int id;
        private String fullName,position;
        private double monthlySalary;
        Employee(int id,String n,String p,double s){
            this.id=id;
            fullName=n;
            position=p;
            monthlySalary=Math.max(0,s);
        }
        public void raiseSalary(double percent){
            if(percent>0)monthlySalary*=1+percent/100;
        }
        public double getAnnualSalary(){
            return monthlySalary*12;
        }
        public void printBadge(){
            System.out.printf("#%d %s — %s, %.2f грн/міс.%n",id,fullName,position,monthlySalary);
        }
    }
      static void task8() {
        Employee emp=new Employee(1,"Влад Шевченко","Junior Developer",20000);
        emp.raiseSalary(15);
        emp.printBadge();
        System.out.println("Річна: "+emp.getAnnualSalary());
    }
      static class User {
        private String login,email,role;
        private boolean isActive;
        public User(String l,String e,String r,boolean a){
            login=l;email=e;role=r;isActive=a;
        }
        public User(String l,String e){
            this(l,e,"USER",true);
        }
        public User(String l){
            this(l,l+"@domain.com");
        }
        public User(){this("guest");}
        public void printProfile(){
            System.out.printf("%s | %s | %s | активний: %b%n",login,email,role,isActive);
        }
    }
     static void task9() {
        new User().printProfile();
        new User("daniil","a@mail.com","ADMIN",true).printProfile();
    }
        static class Fraction {
        private int numerator,denominator;
        Fraction(int n,int d){
            if(d==0) {
                System.out.println("Помилка: знаменник дорівнює 0; встановлено 1.");
                d=1;
            }if(d<0){n=-n;d=-d;
            }
            int g=gcd(n,d);
            numerator=n/g;
            denominator=d/g;}
        Fraction(int whole){
            this(whole,1);
        } Fraction(){
            this(0,1);}
        private int gcd(int a,int b){
            a=Math.abs(a);
            b=Math.abs(b);
            while(b!=0){
                int t=b;
                b=a%b;
                a=t;}
            return a==0?1:a;}
        public void print(){
            System.out.print(denominator==1?""+numerator:numerator+"/"+denominator);}
        public double toDouble(){
            return (double)numerator/denominator;
        }
    }
      static void task10() {
        Fraction fraction=new Fraction(8,12);
        fraction.print();
        System.out.println(" = "+fraction.toDouble());
    }
       static class Car {
        private String brand,model;
        private int year;
        private double mileage;
        private boolean engineStarted;
        Car(String b,String m,int y,double km){
            brand=b;
            model=m;
            year=y;
            mileage=Math.max(0,km);
        }
        Car(String b,String m,int y){
            this(b,m,y,0);
        }
        Car(){
            this("Unknown","Standard",2024);}
        public void startEngine(){
            engineStarted=true;
        }
        public void stopEngine(){
            engineStarted=false;}
        public void drive(double d){
            if(engineStarted&&d>0)mileage+=d;
            else if(!engineStarted)System.out.println("Спершу заведіть двигун!");
        }
    }
     static void task11() {
        Car car=new Car();
        car.startEngine();
        car.drive(150);
        System.out.println("Поїздку виконано.");
    }
        static class SmartBulb {
        private int brightness,colorTemp;
        private boolean isOn;
        SmartBulb(int b,int c,boolean on){
            brightness=Math.max(0,Math.min(100,b));
            colorTemp=Math.max(2700,Math.min(6500,c));
            isOn=on;
        }
        SmartBulb(int b){
            this(b,4000,true);
        } SmartBulb(){this(50);}
        public void printStatus(){
            System.out.printf("Яскравість: %d%%, температура: %d K, увімкнена: %b%n",brightness,colorTemp,isOn);
        }
    }
      static void task12() {
        new SmartBulb().printStatus();
        new SmartBulb(80).printStatus();
    }
       static class QueryBuilder {
        private String table,fields="*",whereClause="";
        QueryBuilder(String t){table=t;}
        QueryBuilder select(String f){
            fields=f;return this;
        }
        QueryBuilder where(String c){
            whereClause=c;return this;
        }
        String build(){
            return "SELECT "+fields+" FROM "+table+(whereClause.isEmpty()?"":" WHERE "+whereClause)+";";}
    }
        static void task13() {
        System.out.println(new QueryBuilder("users").select("id, name, email").where("age >= 18").build());
    }
       static class CoffeeOrder {
    private String type, size;
    private int sugarCount;
    private boolean withSyrup;
    private double finalPrice;
    CoffeeOrder(String t, String s, int sugar, boolean syrup) {
        type = t;
        size = s;
        sugarCount = Math.max(0, sugar);
        withSyrup = syrup;
        finalPrice = calculatePrice();
    }
    CoffeeOrder(String t, String s) {
        this(t, s, 0, false);
    }
    CoffeeOrder(String t) {
        this(t, "Medium");
    }
    private double calculatePrice() {
        double p = type.equalsIgnoreCase("Еспресо") ? 40
                : type.equalsIgnoreCase("Капучино") ? 55
                : type.equalsIgnoreCase("Лате") ? 60 : 0;
        double k = size.equalsIgnoreCase("Small") ? 1
                : size.equalsIgnoreCase("Large") ? 1.6 : 1.3;

        return p * k + (withSyrup ? 15 : 0);
    }
    public void printReceipt() {
        System.out.printf(
                "%s, %s, цукор: %d, сироп: %b — %.2f грн%n",
                type, size, sugarCount, withSyrup, finalPrice
        );
    }
}
       static void task14() {
    new CoffeeOrder("Капучино", "Large", 1, true).printReceipt();
}
    static class Box {
        private double width,height,depth;
        private String material;
        Box(double w,double h,double d,String m){
            width=w;
            height=h;
            depth=d;
            material=m;
        }
        Box(double s,String m){
            this(s,s,s,m);
        } Box(Box o){
            this(o.width,o.height,o.depth,o.material);}
        public double getVolume(){
            return width*height*depth;
        }
        public double getSurfaceArea(){
            return 2*(width*height+width*depth+height*depth);}
       public void printBox(){
            System.out.printf("Коробка %s: %.2f x %.2f x %.2f, об'єм %.2f%n",material,width,height,depth,getVolume());
        }
    }
    static void task15() {
        Box box=new Box(3,"картон");
        box.printBox();
        new Box(box).printBox();
    }
       static class FlightTicket {
        private String ticketNumber,passengerName,flightNumber,departureCity,arrivalCity,seatNumber;private boolean hasBaggage;
        FlightTicket(String tn,String pn,String fn,String dc,String ac,String sn,boolean b){
            ticketNumber=tn;
            passengerName=pn;
            flightNumber=fn;
            departureCity=dc;
            arrivalCity=ac;
            seatNumber=sn;
            hasBaggage=b;
        }
        FlightTicket(String tn,String pn,String fn,String dc,String ac){
            this(tn,pn,fn,dc,ac,"UNASSIGNED",false);}
        void assignSeat(String s){
            seatNumber=s;
        }
        void printBoardingPass(){
            System.out.printf("%s | %s | %s: %s → %s | місце %s | багаж %b%n",
                    ticketNumber,passengerName,flightNumber,departureCity,arrivalCity,seatNumber,hasBaggage);}
    }
       static void task16() {
        FlightTicket ticket=new FlightTicket("T001","василь","PS101","Київ","Дубаї");
        ticket.assignSeat("12A");
        ticket.printBoardingPass();
    }
       static class MathOperations {
        public int add(int a,int b){
            return a+b;
        } public double add(double a,double b){
            return a+b;
        } public int add(int a,int b,int c){
            return a+b+c;
        }
        String add(String a,String b){
            return a+" "+b;
        }
        public int multiply(int a,int b){
            return a*b;
        } public double multiply(double a,double b){
            return a*b;
        } public String multiply(String s,int n){
            return n<=0?"":s.repeat(n);}
    }
       static void task17() {
        MathOperations mo=new MathOperations();
        System.out.println(mo.add(2,3)+"; "+mo.add(2.5,3.5)+"; "
                +mo.add("Hello","Java")+"; "+mo.multiply("Hi ",3));
    }
       static class DocumentPrinter {
        public void print(String s){
            System.out.println(s);
        } public void print(int n){
            System.out.println("[INT]: "+n);
        }
        public void print(double n,int decimals){
            System.out.println(String.format("%."+Math.max(0,decimals)+"f",n));
        }
        public void print(String[] lines){
            for(int i=0; i<lines.length; i++)System.out.println((i+1)+". "+lines[i]);
        }
        public void print(String s,boolean upper){
            System.out.println(upper?s.toUpperCase():s);
        }
    }
        static void task18() {
        DocumentPrinter dp=new DocumentPrinter();
        dp.print("Тест");
        dp.print(123);dp.print(3.14159,2);
        dp.print(new String[]{"перший","другий"});
        dp.print("hello",true);
    }
        static class AreaCalculator {
        double calculateArea(double side){
            return side*side;
        }
        double calculateArea(double width,double height){
            return width*height;
        }
        double calculateArea(double radius,boolean isCircle){
            return isCircle?Math.PI*radius*radius:0;
        }
        double triangleArea(double a,double b,double c){
            double s=(a+b+c)/2;
            return Math.sqrt(Math.max(0,s*(s-a)*(s-b)*(s-c)));
        }
        double trapezoidArea(double base1,double base2,double height){
            return (base1+base2)*height/2;}
    }
    static void task19() {
        AreaCalculator ac=new AreaCalculator();
        System.out.println("Квадрат: "+ac.calculateArea(4)+", коло: "+
                ac.calculateArea(2,true)+", трикутник: "+ac.triangleArea(3,4,5)
                +", трапеція: "+ac.trapezoidArea(3,5,4));
    }
       static class Logger {
        void log(String m){
            System.out.println("[INFO] "+m);
        }
        void log(String l,String m){
            System.out.println("["+l+"] "+m);
        }
        void log(String l,int c,String m){
            System.out.println("["+l+"] (Code: "+c+"): "+m);
        }
        void log(String tag,String m,boolean timestamp){
            System.out.println("["+tag+"] "+m+(timestamp?" | time="+System.currentTimeMillis():""));
        }
    }
      static void task20() {
        Logger log=new Logger();
        log.log("Старт");log.log("WARN","Попередження");
        log.log("ERROR",404,"Не знайдено");
        log.log("APP","Готово",true);
    }
        static class ArraySearcher {
        int find(int[] a,int t){
            return find(a,t,0);
        }
        int find(int[] a,int t,int start){
            for(int i=Math.max(0,start);
                i<a.length;i++)
                if(a[i]==t)return i;
            return -1;}
        int find(String[] a,String t){
            for(int i=0;i<a.length;i++)
                if(java.util.Objects.equals(a[i],t))return i;
            return -1;}
        int find(String[] a,String t,boolean ignoreCase){
            for(int i=0;i<a.length;i++)
                if(a[i]!=null&&(ignoreCase?a[i].equalsIgnoreCase(t):a[i].equals(t)))return i;
            return -1;}
    }
      static void task21() {
        ArraySearcher searcher=new ArraySearcher();
        System.out.println(searcher.find(new int[]{1,4,7},4));
        System.out.println(searcher.find(new String[]{
                "Java","Python"},"java",true));
    }
        static class DateService {
        private int day,month,year;
        DateService(int d,int m,int y){
            day=d;month=m;year=y;
        }
        public void add(int days){
            add(days,0,0);
        }
        public void add(int days,int months){
            add(days,months,0);
        }
       public void add(int days,int months,int years){
            int total=(month-1)+months;
            year+=years+Math.floorDiv(total,12);
            month=Math.floorMod(total,12)+1;
            int d0=day+days;while(d0>30){
                d0-=30;month++;
                if(month>12){month=1;year++;
                }
            }while(d0<1){
                d0+=30;month--;
                if(month<1){
                    month=12;year--;}}day=d0;}
        public void printDate(){
            System.out.printf("%02d.%02d.%04d%n",day,month,year);}
    }
      static void task22() {
        DateService date=new DateService(15,3,2024);
        date.add(20);date.printDate();
        date.add(0,3);
        date.printDate();
    }
       static class SalaryCalculator {
       public double calculate(double base){
            return base;
        }
       public double calculate(double base,double bonus){
            return base+bonus;
        }
       public double calculate(double base,double percent,boolean tax){
            double v=base*(1+percent/100);
            return tax?v*0.805:v;}
       public double calculate(double base,int overtime,double rate){
            return base+overtime*rate;}
    }
     static void task23() {
        SalaryCalculator sc=new SalaryCalculator();
        System.out.println(sc.calculate(20000)+"; "+sc.calculate(20000,1000)+"; "
                +sc.calculate(20000,10,true)+"; "+sc.calculate(20000,5,500));
    }
           static class ArrayFilter {
       public int[] filter(int[] a,int threshold){
            return java.util.Arrays.stream(a).filter(x->x>threshold).toArray();}
        public int[] filter(int[] a,int min,int max){
            return java.util.Arrays.stream(a).filter(x->x>=min&&x<=max).toArray();}
       public int[] filter(int[] a,boolean evens){
            return java.util.Arrays.stream(a).filter(x->Math.floorMod(x,2)==(evens?0:1)).toArray();
        }
    }
         static void task24() {
        ArrayFilter filter=new ArrayFilter();
        int[] nums={12,5,8,19,24,3,16};
        System.out.println(java.util.Arrays.toString(filter.filter(nums,10)));
        System.out.println(java.util.Arrays.toString(filter.filter(nums,true)));
    }
        public static class UserAccount {
        private final int id;
        private final String username;
            private final String email;
        private static int nextId=1001;
        UserAccount(String u,String e){
            id=nextId++;
            username=u;
            email=e;}
        public static int getNextAvailableId(){
            return nextId;
        }static void resetIdSequence(int id){nextId=id;}
        public void print(){
            System.out.printf("%d | %s | %s%n",id,username,email);}
    }
        static void task25() {
        new UserAccount("anna","a@mail.com").print();
        new UserAccount("ivan","i@mail.com").print();
        new UserAccount("maria","m@mail.com").print();
    }
     static class ServerConfig {
        public static final String SERVER_NAME="AlphaEnterprise";
        public static final int MAX_CONNECTIONS=5;
        private static int activeConnections=0;
        static boolean connect(){
            if(activeConnections<MAX_CONNECTIONS){activeConnections++;
                return true;
            }return false;}
        static void disconnect(){
            if(activeConnections>0)activeConnections--;
        }
        static void printServerStatus(){
            System.out.printf("%s: підключень %d, вільно %d%n",SERVER_NAME,activeConnections,MAX_CONNECTIONS-activeConnections);}
    }
     static void task26() {
        for(int i=1;i<=6;i++)
            System.out.println("Користувач "+i+": "+(ServerConfig.connect()?"підключено":"відмова"));
        ServerConfig.printServerStatus();
    }
         static class MathUtils {
        public static final double PI=3.1415926535,E=2.7182818284;
        private MathUtils(){}
        public static long factorial(int n){
            if(n<0||n>20)throw new IllegalArgumentException("n має бути від 0 до 20");
            long r=1;
            for(int i=2;i<=n;i++)r*=i;
            return r;}
       public static double power(double b,int e){
            if(b==0&&e<0)throw new ArithmeticException("Ділення на нуль");
            double r=1;
            for(int i=0;i<Math.abs((long)e);i++)r*=b;
            return e<0?1/r:r;}
        public static int gcd(int a,int b){
            a=Math.abs(a);
            b=Math.abs(b);
            while(b!=0){
                int t=b;b=a%b;a=t;
            }return a;}
        public static int clamp(int v,int min,int max){
            if(min>max)throw new IllegalArgumentException("min > max");
            return Math.max(min,Math.min(max,v));}
    }
      static void task27() {
        System.out.println("5! = "+MathUtils.factorial(5)+", 2^-3 = "+MathUtils.power(2,-3)+", НСД = "+MathUtils.gcd(24,18)+", clamp = "+MathUtils.clamp(20,0,10));
    }
       static class CurrencyExchange {
        private static double usdToUahRate=41.5,eurToUahRate=45.2;
        public static void updateRates(double usd,double eur){
            if(usd>0&&eur>0){usdToUahRate=usd;eurToUahRate=eur;}
        }
        public static double uahToUsd(double uah){
            return uah/usdToUahRate;
        }public static double usdToUah(double usd){
            return usd*usdToUahRate;
        }public static double eurToUah(double eur){
            return eur*eurToUahRate;}
    }
      static void task28() {
        System.out.println("100 USD = "+CurrencyExchange.usdToUah(100)+" грн");
        CurrencyExchange.updateRates(42,46);
        System.out.println("Після зміни курсу: "+CurrencyExchange.usdToUah(100)+" грн");
    }
      static class FleetCar {
        private String vinCode;
        private double currentMileage;
        private static int totalCars=0;
        private static double totalCompanyMileage=0;
        FleetCar(String vin,double km){
            vinCode=vin;
            currentMileage=Math.max(0,km);
            totalCars++;
            totalCompanyMileage+=currentMileage;}
        public void addTrip(double km){
            if(km>0){
                currentMileage+=km;
                totalCompanyMileage+=km;}
        }
       public static void printFleetSummary(){
            System.out.printf("Авто: %d, сумарний пробіг: %.2f км%n",totalCars,totalCompanyMileage);}
    }
       static void task29() {
        FleetCar f1=new FleetCar("VIN1",1000),f2=new FleetCar("VIN2",2000),f3=new FleetCar("VIN3",500);
        f1.addTrip(150);
        f2.addTrip(100);
        FleetCar.printFleetSummary();
    }
        static class StringUtils {
        private StringUtils(){}
        static boolean isPalindrome(String s){
            String t=s.replaceAll("\\s+","").toLowerCase();
            return t.contentEquals(new StringBuilder(t).reverse());}
        static String reverse(String s){
            return new StringBuilder(s).reverse().toString();}
        static int countVowels(String s){
            int n=0;
            for(char c:s.toLowerCase().toCharArray())
                if("aeiouаеєиіїоуюя".indexOf(c)>=0)n++;return n;}
        static String maskCardNumber(String s){
            String digits=s.replaceAll("\\D","");
            String last=digits.length()<=4?digits:digits.substring(digits.length()-4);
            return "**** **** **** "+last;}
    }
       static void task30() {
        System.out.println(StringUtils.isPalindrome("А роза упала на лапу Азора"));
        System.out.println(StringUtils.reverse("Java"));
        System.out.println(StringUtils.countVowels("Привіт Java"));
        System.out.println(StringUtils.maskCardNumber("1234 5678 9012 3456"));
    }
        static class GameSession {
        private String sessionToken,hostPlayer;
        private boolean isActive;
        private static int activeSessionsCount=0;
        static final int MAX_SESSIONS=3;
        private GameSession(String host){
            hostPlayer=host;
            sessionToken="SESSION-"+System.nanoTime();
            isActive=true;}
        static GameSession createSession(String host){
            if(activeSessionsCount>=MAX_SESSIONS){
                System.out.println("Помилка: усі сервера перевантажені!");
                return null;}activeSessionsCount++;
            return new GameSession(host);}
        void terminate(){
            if(isActive){isActive=false;activeSessionsCount--;}
        }
    }
    static void task31() {
        GameSession g1=GameSession.createSession("Олена"),g2=GameSession.createSession("Іван"),
                g3=GameSession.createSession("Аліна"),g4=GameSession.createSession("Андрій");
        if(g1!=null)g1.terminate();
    }
       static class PhysicsEngine {
        static final double G=9.80665,SPEED_OF_LIGHT=299792458.0;
        private PhysicsEngine(){}
        static double freeFallDistance(double t){
            return G*t*t/2;
        }
        public static double kineticEnergy(double m,double v){
            return m*v*v/2;
        }
       public static double restEnergy(double m){
            return m*SPEED_OF_LIGHT*SPEED_OF_LIGHT;}
    }
    public static void task32() {
        System.out.println("Падіння за 5 с: "+PhysicsEngine.freeFallDistance(5)+" м");
        System.out.println("Енергія спокою 1 г: "+PhysicsEngine.restEnergy(0.001)+" Дж");
    }
        static class Point {
        private double x,y;
        Point(double x,double y){
            this.x=x;this.y=y;
        }double getX(){
            return x;
        }double getY(){
            return y;}
    }
    static class LineSegment {
        private Point start,end;
        LineSegment(Point s,Point e){
            start=s;
            end=e;
        }LineSegment(double x1,double y1,double x2,double y2){
            this(new Point(x1,y1),new Point(x2,y2));}
        double getLength(){
            return Math.hypot(end.getX()-start.getX(),end.getY()-start.getY());}
        Point getMidPoint(){
            return new Point((start.getX()+end.getX())/2,(start.getY()+end.getY())/2);}
        void printSegment(){
            System.out.printf("Відрізок довжини %.2f, середина (%.2f; %.2f)%n",getLength(),getMidPoint().getX(),getMidPoint().getY());}
    }
    static void task33() {
        new LineSegment(0,0,3,4).printSegment();
    }
       static class ClientAccount {
        private String iban,owner;
        private double balance;
        ClientAccount(String i,String o,double b){
            iban=i;
            owner=o;balance=Math.max(0,b);}
        public boolean transferTo(ClientAccount r,double amount){
            if(r==null||r==this||amount<=0||balance<amount)return false;
            balance-=amount;r.balance+=amount;return true;}
        public void printAccount(){System.out.printf("%s (%s): %.2f грн%n",owner,iban,balance);}
    }
static void task34() {
    ClientAccount ivan = new ClientAccount("UA1", "Іван", 10000), maria = new ClientAccount("UA2", "Марія", 2000);
    System.out.println("Переказ успішний: " + ivan.transferTo(maria, 3500));
    ivan.printAccount();
    maria.printAccount();
}
    static class Engine {
        private String serialNumber;
        private int horsePower;
        private boolean isRunning;
        Engine(String s,int hp){
            serialNumber=s;
            horsePower=hp;}
        void start(){isRunning=true;}
        public void stop(){isRunning=false;}
        public boolean isRunning(){
            return isRunning;}
        public int getHorsePower(){
            return horsePower;}
    }
    static class CarWithEngine {
        private String brand,model;
        private Engine engine;
        CarWithEngine(String b,String m,Engine e){
            brand=b;model=m;engine=e;}
        void startCar(){
            engine.start();
            System.out.println(brand+" готовий до руху!");}
        void turnOff(){engine.stop();}
        void printSpecs(){System.out.printf("%s %s, двигун %d к.с., працює: %b%n",brand,model,engine.getHorsePower(),engine.isRunning());}
    }
    static void task35() {
        CarWithEngine car2=new CarWithEngine("Toyota","Corolla",new Engine("ENG1",140));
        car2.startCar();
        car2.printSpecs();
        car2.turnOff();
    }
      static class Processor {
        private String model;
        private double frequencyGHz,price;
        Processor(String m,double f,double p){
            model=m;frequencyGHz=f;price=p;
        }
        public double getPrice(){
            return price;}
        public String toString(){
            return model+" "+frequencyGHz+" GHz";}
    }
    static class Memory {
        private int sizeGB,frequencyMHz;
        private double price;
        Memory(int s,int f,double p){
            sizeGB=s;frequencyMHz=f;price=p;}
        public double getPrice(){return price;}
        public String toString(){return sizeGB+" GB "+frequencyMHz+" MHz";}
    }
    static class Computer {
        private String title;
        private Processor cpu;
        private Memory ram;
        private double casePrice;
        Computer(String t,Processor c,Memory r,double p){
            title=t;cpu=c;ram=r;casePrice=p;
        }
       public double calculateTotalPrice(){
            return cpu.getPrice()+ram.getPrice()+casePrice;}
        public void upgradeMemory(Memory r){
            ram=r;System.out.println("Оперативну пам'ять оновлено.");}
       public void printSpecs(){
            System.out.printf("%s | CPU: %s | RAM: %s | ціна: %.2f грн%n",title,cpu,ram,calculateTotalPrice());}
    }

static void task36() {
        Computer pc=new Computer("Мій ПК",new Processor("Ryzen 5",3.6,5000),new Memory(16,3200,1500),2500);
        pc.printSpecs();
        pc.upgradeMemory(new Memory(32,3600,2800));
        pc.printSpecs();
    }

    static class Hero {
        private String name;
        private int health,attackPower,defense;
        Hero(String n,int h,int a,int d){
            name=n;
            health=Math.max(0,h);
            attackPower=Math.max(0,a);
            defense=Math.max(0,d);}
        public void attack(Hero target){
            if(target==null||!isAlive())return;
            int damage=Math.max(1,attackPower-target.defense);
            target.health=Math.max(0,target.health-damage);
            System.out.printf("%s атакує %s на %d шкоди. HP цілі: %d%n",name,target.name,damage,target.health);
        }
        public boolean isAlive(){
            return health>0;}
        String getName(){
            return name;}
    }
static void task37() {
        Hero knight=new Hero("Лицар",30,8,3),orc=new Hero("Орк",25,7,2);
        while(knight.isAlive()&&orc.isAlive()){knight.attack(orc);
            if(orc.isAlive())orc.attack(knight);}
        System.out.println("Переможець: "+(knight.isAlive()?knight.getName():orc.getName()));
    }
    static class ShopProduct {
        private int id;
        private String title;
        private double price;
        ShopProduct(int i,String t,double p){
            id=i;title=t;
            price=Math.max(0,p);}
        public double getPrice(){
            return price;}
        public String toString(){
            return title+" ("+String.format("%.2f",price)+" грн)";}
    }
    static class Customer {
        private String name;
        private double walletBalance;
        Customer(String n,double b){
            name=n;
            walletBalance=Math.max(0,b);}
        public boolean pay(double amount){
            if(amount<0||walletBalance<amount)return false;
            walletBalance-=amount;
            return true;}
        public String getName(){
            return name;}
        public double getBalance(){
            return walletBalance;}
    }
    static class Order {
        private Customer customer;
        private ShopProduct[] items;
        private int itemCount;
        Order(Customer c,int maxItems){
            customer=c;
            items=new ShopProduct[Math.max(0,maxItems)];}
        public void addProduct(ShopProduct p){
            if(p!=null&&itemCount<items.length)items[itemCount++]=p;
            else System.out.println("Не вдалося додати товар.");}
        public double calculateTotal(){
            double sum=0;
            for(int i=0;i<itemCount;i++)sum+=items[i].getPrice();
            return sum;}
        public boolean checkout(){
            double total=calculateTotal();
            if(customer.pay(total)){System.out.printf("Чек для %s: %.2f грн%n",customer.getName(),total);
                return true;}System.out.println("Недостатньо коштів.");
            return false;}
    }
static void task38() {
        Customer customer=new Customer("Олена",1000);
        Order order=new Order(customer,3);
        order.addProduct(new ShopProduct(1,"Мишка",400));
        order.addProduct(new ShopProduct(2,"Клавіатура",500));
        order.checkout();System.out.println("Залишок: "+customer.getBalance());
    }
    static class Vector3D {
        private double x,y,z;
        Vector3D(double x,double y,double z){
            this.x=x;this.y=y;
            this.z=z;}Vector3D(){
            this(0,0,0);}
        Vector3D add(Vector3D o){
            return new Vector3D(x+o.x,y+o.y,z+o.z);}
        public double dotProduct(Vector3D o){
            return x*o.x+y*o.y+z*o.z;}
        Vector3D crossProduct(Vector3D o){
            return new Vector3D(y*o.z-z*o.y,z*o.x-x*o.z,x*o.y-y*o.x);}
        public boolean isOrthogonalTo(Vector3D o){
            return Math.abs(dotProduct(o))<1e-9;}
       public boolean isEqualTo(Vector3D o){
            return Math.abs(x-o.x)<1e-9&&Math.abs(y-o.y)<1e-9&&Math.abs(z-o.z)<1e-9;}
        public String toString(){
            return String.format("(%.2f, %.2f, %.2f)",x,y,z);}
    }
static void task39() {
        Vector3D v1=new Vector3D(1,0,0),v2=new Vector3D(0,1,0);
        System.out.println("Сума: "+v1.add(v2));
        System.out.println("Скалярний добуток: "+v1.dotProduct(v2));
        System.out.println("Ортогональні: "+v1.isOrthogonalTo(v2));
        System.out.println("Векторний добуток: "+v1.crossProduct(v2));
    }
    static class BookItem {
        private String isbn,title,author;
        private boolean isAvailable=true;
        BookItem(String i,String t,String a){isbn=i;title=t;author=a;}
        void borrowBook(){
            if(isAvailable)isAvailable=false;}
        void returnBook(){
            isAvailable=true;}
        void printBook(){
            System.out.printf("%s — %s, %s | доступна: %b%n",title,author,isbn,isAvailable);
        }
        String getTitle(){
            return title;
        }
        public boolean isAvailable(){
            return isAvailable;}
    }
    static class LibraryCatalog {
        private BookItem[] books;
        private int size;
        LibraryCatalog(int c){
            books=new BookItem[Math.max(0,c)];}
        public void addBook(BookItem b){
            if(b!=null&&size<books.length)books[size++]=b;
            else System.out.println("Каталог заповнений або книга некоректна.");}
        BookItem findBookByTitle(String t){
            for(int i=0;i<size;i++)
                if(books[i].getTitle().equalsIgnoreCase(t))
                    return books[i];return null;}
       public boolean borrowBook(String t){BookItem b=findBookByTitle(t);
            if(b!=null&&b.isAvailable()){b.borrowBook();
                return true;
            }
            return false;}
       public void printCatalog(){
            for(int i=0;i<size;i++)books[i].printBook();}
    }
static void task40() {
        LibraryCatalog library=new LibraryCatalog(5);
        library.addBook(new BookItem("ISBN1","Дім у Волошковому морі","Ті Джей Клюн"));
        library.addBook(new BookItem("ISBN2","Біг Мак","Сергій Жадан"));
        library.addBook(new BookItem("ISBN3","Тигролови","І. Багряний"));
        System.out.println("Перше взяття: "+library.borrowBook("Дім у Волошковому морі"));
        System.out.println("Друге взяття: "+library.borrowBook("Дім у Волошковому морі"));
        library.printCatalog();
    }








}
