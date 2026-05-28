import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//я не розібралась з часом(

public class Main {
    //сортування бульбашкою
    public static void bubbleSort(int[] array, boolean count) {//масив з чисел які треба відсортувати за зростанням або спаданням
        for (int i = 0; i < array.length - 1; i++) {//прохід по елементам масиву
            for (int j = 0; j < array.length - 1 - i; j++) {//порівняння елементів

                //зростання
                if (count && array[j] > array[j + 1]) {//якщо лівий елемент більший за правий - вони міняються
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

                //спадання
                if (!count && array[j] < array[j + 1]) {//якщо правий елемент більший за лівий - вони міняються
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //сортування вставками
    public static void insertionSort(int[] array, boolean count) {
        for (int i = 1; i < array.length; i++) {//перший елемент вже відосртований

            int el = array[i];//елемент який треба вставити у потрібне місце
            int j = i - 1;//попередній ідекс

            //за зростанням
            if (count) {
                while (j >= 0 && array[j] > el) {//поки елемент більший за за el треба зсунути його вправо
                    array[j + 1] = array[j];
                    j--;//сам зсув елементів
                }
            }
            //за спаданням
            else {
                while (j >= 0 && array[j] < el) {//
                    array[j + 1] = array[j];
                    j--;
                }
            }
            array[j + 1] = el;//ставлення el на потрібне місце
        }
    }

    //за вибіркою
    public static void selectionSort(int[] array, boolean count) {
        for (int i = 0; i < array.length - 1; i++) {

            int index = i;

            for (int j = i + 1; j < array.length; j++) {

                //за зростанням
                if (count && array[j] < array[index]) {//пошук найменшего елементу
                    index = j;
                }
                //за спаданням
                if (!count && array[j] > array[index]) {//пошук найбільшого елементу
                    index = j;
                }
            }

            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;//зміна місцями елемент
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        System.out.print("Введіть мінімальне значення: ");
        int min = scanner.nextInt();

        System.out.print("Введіть максимальне значення: ");
        int max = scanner.nextInt();

        int choice;

        while (true) {
            try {
                System.out.print("Оберіть спосіб сортування: 1 - за зростанням, 2 - за спаданням: ");
                choice = scanner.nextInt();

                if (choice != 1 && choice != 2) {
                    throw new IllegalArgumentException("Потрібно ввести 1 або 2");
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Введіть число 1 або 2");
                scanner.nextLine();
            }
        }

        boolean count = (choice == 1);//якщо вибір 1 - це сортування по зростанню
        int[] array = new int[size];//створення основного масиву

        for (int i = 0; i < size; i++) {//прохід по кожному елементу
            array[i] = random.nextInt(max - min + 1) + min;//генерування чисел від мін до макс
        }
        //створення копій усіх масивів щоб кожний раз сортувались однакові масиви
        int[] bubbleArray = Arrays.copyOf(array, array.length);
        int[] insertionArray = Arrays.copyOf(array, array.length);
        int[] selectionArray = Arrays.copyOf(array, array.length);

        System.out.println("\nПочатковий масив:");
        System.out.println(Arrays.toString(array));

        bubbleSort(bubbleArray, count);//сортування бульбашкове
        System.out.println("\nМасив після сортування бульбашкою:");
        System.out.println(Arrays.toString(bubbleArray));

        insertionSort(insertionArray, count);//сортування вставкою
        System.out.println("\nМасив після сортування вставками:");
        System.out.println(Arrays.toString(insertionArray));

        selectionSort(selectionArray, count);//сортування вибіркою
        System.out.println("\nМасив після сортування вибіркою:");
        System.out.println(Arrays.toString(selectionArray));

        scanner.close();
    }
}