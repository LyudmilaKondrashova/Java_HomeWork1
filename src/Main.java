import java.util.Random;

public class Main {

    public static final int RANGE = 1000;

    public static void main(String[] args) {

        int i = getRandomNumber(RANGE);
        int n = higestBitNumber(i);
        int[] m1 = getArrayMulty(i, Short.MAX_VALUE, n);
        int[] m2 = getArrayNotMulty(Short.MIN_VALUE, i, n);
        System.out.println("Случайное целое число в диапазоне от -1000 до 1000: " + i);
        System.out.println("Номер старшего значащего бита выпавшего числа: " + n);
        System.out.printf("Все кратные %d числа в диапазоне от %d до %d: \n", n, i, Short.MAX_VALUE);
        printArray(m1);
        System.out.printf("Все некратные %d числа в диапазоне от %d до %d: \n", n, Short.MIN_VALUE, i);
        printArray(m2);
    }

    //1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
    public static int getRandomNumber(int rang) {
        Random rand = new Random();
        return rand.nextInt(rang * 2 + 1) - 1000;
    }

    //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    public static int higestBitNumber(int numb) {
        int absNumb = Math.abs(numb);
        int count = 1;
        while (absNumb != 1) {
            absNumb >>= 1;
            count++;
        }
        return count;
    }

    //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    public static int[] getArrayMulty(int minRange, int maxRange, int numb) {
        int count = 0;
        for (int ind = minRange; ind <= maxRange; ind++) {
            if (ind % numb == 0) {
                count++;
            }
        }
        int[] arrayMulty = new int[count];
        count = 0;
        for (int ind = minRange; ind <= maxRange; ind++) {
            if (ind % numb == 0) {
                arrayMulty[count] = ind;
                count++;
            }
        }
        return arrayMulty;
    }

    //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    public static int[] getArrayNotMulty(int minRange, int maxRange, int numb) {
        int count = 0;
        for (int ind = minRange; ind <= maxRange; ind++) {
            if (ind % numb != 0) {
                count++;
            }
        }
        int[] arrayMulty = new int[count];
        count = 0;
        for (int ind = minRange; ind <= maxRange; ind++) {
            if (ind % numb != 0) {
                arrayMulty[count] = ind;
                count++;
            }
        }
        return arrayMulty;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int ind = 0; ind < array.length; ind++) {
            if ((ind + 1) % 15 != 0) {
                System.out.print(array[ind] + " ");
            }
            else {
                System.out.println(array[ind] + " ");
            }
        }
        System.out.println("]");
    }

}