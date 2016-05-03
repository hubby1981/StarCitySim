package games.biitworx.starcitysim;

/**
 * Created by marcel.weissgerber on 03.05.2016.
 */
public class MenuWatcher {

    public static int START_MENU_0 = 0;
    public static int END_MENU_0 = 125;
    public static int MAX_MENU_0 = 360;
    public static int MIN_MENU_0 = 0;
    public static int DIR_MENU_0 = 0;

    public static int START_MENU_1 = 160;
    public static int END_MENU_1 = 245;
    public static int MAX_MENU_1 = 360;
    public static int MIN_MENU_1 = 0;
    public static int DIR_MENU_1 = 0;

    public static int START_MENU_2 = 0;
    public static int END_MENU_2 = 200;
    public static int MAX_MENU_2 = 360;
    public static int MIN_MENU_2 = 0;
    public static int DIR_MENU_2 = 0;

    public static int START_MENU_3 = 0;
    public static int END_MENU_3 = 360;
    public static int MAX_MENU_3 = 360;
    public static int MIN_MENU_3 = 0;
    public static int DIR_MENU_3 = 0;


    public static void move() {

        if (DIR_MENU_0 == 0) {
            if (END_MENU_0 == MAX_MENU_0 && DIR_MENU_0 == 0) {
                END_MENU_0 -= 1;

            } else if (END_MENU_0 < MAX_MENU_0 && END_MENU_0 > MIN_MENU_0 && DIR_MENU_0 == 0) {
                END_MENU_0 -= 1;

            } else {
                DIR_MENU_0 = 1;
            }
        }
        if (DIR_MENU_0 == 1) {
            if (END_MENU_0 == MIN_MENU_0 && DIR_MENU_0 == 1) {
                END_MENU_0 += 1;

            } else if (END_MENU_0 < MAX_MENU_0 && END_MENU_0 > MIN_MENU_0 && DIR_MENU_0 == 1) {
                END_MENU_0 += 1;

            } else {
                DIR_MENU_0 = 0;
            }
        }


    }

    public static void move2() {

        if (DIR_MENU_1 == 0) {
            if (END_MENU_1 == MAX_MENU_1 && DIR_MENU_1 == 0) {
                END_MENU_1 -= 1;

            } else if (END_MENU_1 < MAX_MENU_1 && END_MENU_1 > MIN_MENU_1 && DIR_MENU_1 == 0) {
                END_MENU_1 -= 1;

            } else {
                DIR_MENU_1 = 1;
            }
        }
        if (DIR_MENU_1 == 1) {
            if (END_MENU_1 == MIN_MENU_1 && DIR_MENU_1 == 1) {
                END_MENU_1 += 1;

            } else if (END_MENU_1 < MAX_MENU_1 && END_MENU_1 > MIN_MENU_1 && DIR_MENU_1 == 1) {
                END_MENU_1 += 1;

            } else {
                DIR_MENU_1 = 0;
            }
        }


    }
    public static void move3() {

        if (DIR_MENU_2 == 0) {
            if (END_MENU_2 == MAX_MENU_2 && DIR_MENU_2 == 0) {
                END_MENU_2 -= 1;

            } else if (END_MENU_2 < MAX_MENU_2 && END_MENU_2 > MIN_MENU_2 && DIR_MENU_2 == 0) {
                END_MENU_2 -= 1;

            } else {
                DIR_MENU_2 = 1;
            }
        }
        if (DIR_MENU_2 == 1) {
            if (END_MENU_2 == MIN_MENU_2 && DIR_MENU_2 == 1) {
                END_MENU_2 += 1;

            } else if (END_MENU_2 < MAX_MENU_2 && END_MENU_2 > MIN_MENU_2 && DIR_MENU_2 == 1) {
                END_MENU_2 += 1;

            } else {
                DIR_MENU_2 = 0;
            }
        }


    }

    public static void move4() {

        if (DIR_MENU_3 == 0) {
            if (END_MENU_3  == MAX_MENU_3  && DIR_MENU_3  == 0) {
                END_MENU_3  -= 1;

            } else if (END_MENU_3  < MAX_MENU_3  && END_MENU_3  > MIN_MENU_3  && DIR_MENU_3  == 0) {
                END_MENU_3  -= 1;

            } else {
                DIR_MENU_3  = 1;
            }
        }
        if (DIR_MENU_3  == 1) {
            if (END_MENU_3  == MIN_MENU_3  && DIR_MENU_3  == 1) {
                END_MENU_3  += 1;

            } else if (END_MENU_3  < MAX_MENU_3  && END_MENU_3  > MIN_MENU_3  && DIR_MENU_3  == 1) {
                END_MENU_3  += 1;

            } else {
                DIR_MENU_3  = 0;
            }
        }


    }
}
