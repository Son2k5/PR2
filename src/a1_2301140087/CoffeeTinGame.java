package a1_2301140087;
import java.util.Arrays;
import java.util.Random;


public class CoffeeTinGame {
    /** constant value for the green bean*/
    private static final char GREEN = 'G';
    /** constant value for the blue bean*/
    private static final char BLUE = 'B';
    /** constant for removed beans */
    private static final char REMOVED = '-';
    /** the null character*/
    private static final char NULL = '\u0000';

    //Create a bag of beans at least 30 beans
    private static char[] BeansBag = new char[30];

    /**
     * create 1 to 10 is blue beans
     * create 11-20 is green beans
     * create 21-3= is empty bean
     */
    static {
        int count =0;
        for (char bean : BeansBag) {
            if (count < 10) {
                BeansBag[count] = BLUE;
            } else if (count < 20) {
                BeansBag[count] = GREEN;
            } else {
                BeansBag[count] = REMOVED;
            }
            count++; // update
        }
    }

    //Main class
    public static void main(String[] args) {
        // initialise some beans
        char[][] tins = {
                {BLUE, BLUE, BLUE, GREEN, GREEN},
                {BLUE, BLUE, BLUE, GREEN, GREEN, GREEN},
                {GREEN},
                {BLUE},
                {BLUE, GREEN}
        };

        for (int i = 0; i < tins.length; i++) {
            char[] tin = tins[i];

            // expected last bean
            // p0 = green parity /\
            // (p0=1 -> last=GREEN) /\ (p0=0 -> last=BLUE)
            // count number of greens
            int greens = 0;
            for (char bean : tin) {
                if (bean == GREEN)
                    greens++;
            }
            // expected last bean
            final char last = (greens % 2 == 1) ? GREEN : BLUE;

            // print the content of tin before the game
            System.out.printf("%nTIN (%d Gs): %s %n", greens, Arrays.toString(tin));

            // perform the game
            // get actual last bean
            char lastBean = tinGame(tin);
            // lastBean = last \/ lastBean != last

            // print the content of tin and last bean
            System.out.printf("tin after: %s %n", Arrays.toString(tin));

            // check if last bean as expected and print
            if (lastBean == last) {
                System.out.printf("last bean: %c%n", lastBean);
            } else {
                System.out.printf("Oops, wrong last bean: %c (expected: %c)%n", lastBean, last);
            }
        }
    }

    // Create tinGame method to control the game
    public static char tinGame(char[] tin) {
        while(hasAtLeastTwoBeans(tin)){
            char[] twoBeans = takeTwo(tin);
            char bean1 = twoBeans[0];
            char bean2 = twoBeans[1];
            updateTin(tin, bean1, bean2);
        }
        return anyBeans(tin);
    }

    // Cteate method to check the number of beans is two or not
    public static boolean hasAtLeastTwoBeans(char[] tin) {
        int count =0;
        for(char i: tin){
            // create a condition to remove the null value
            if(i != REMOVED){
                count++;
            }
            if(count >=2 ){
                return true;
            }
        }
        return false;
    }

    //The method use to take 2 beans
    public static char[] takeTwo(char[] tin) {
        return new char[]{takeOne(tin), takeOne(tin)};
    }

    // the method use to take a single beans
    public static char takeOne(char[] tin) {
        int position = randInt(tin.length);
        while (tin[position] == REMOVED){
            // this loop use to create a new position if value in it is null
            position = randInt(tin.length);
        }
        char bean = tin[position];
        tin[position] = REMOVED;
        return bean;
    }

    //Create a random number method to solve takeOne method
    public static int randInt(int n) {
        Random rand = new Random();
        return rand.nextInt(n);
    }

    //Create update beans to check two beans is blue or green
    public static void updateTin(char[] tin, char first, char second) {
        if(first == second){
            char newBlueBean = getBean(BeansBag,BLUE);
            putInToTin(tin, newBlueBean);

        }else{
            putInToTin(tin,GREEN);
        }
    }
    //this method use to take bean from tin that is the same color with blue bean
    public static char getBean(char[] beansBag, char beanType) {
        int value= randInt(beansBag.length);
        char takeBean = beansBag[value];
        do{
            value = randInt(beansBag.length);
            takeBean = beansBag[value];
        }while(beansBag[value] != beanType);
        beansBag[value] = REMOVED;
        return takeBean;
    }

    // Method to put the bean to the tin
    private static void putInToTin(char[] tin, char bean) {
        for(int i =0; i< tin.length; i++){
            if(tin[i] == REMOVED){
                tin[i] = bean;
                break;
            }
        }
    }
    private static char anyBeans(char[] tin) {
        for(int i =0; i< tin.length; i++){
            if(tin[i] != REMOVED){
                return tin[i];
            }
        }
        return NULL;
    }

}
