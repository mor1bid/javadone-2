import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
// import java.lang.System.Logger;
import java.io.IOException;
import java.util.logging.*;
// import java.io.File;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
import java.time.*;
import java.sql.*;
/**
 * dz
 */
public class dz {
    public static final String DB_URL = "jdbc:h2:/c/Users/De/Desktop/osjunkyard/gb/ZsYP/Java/II/db/stockExchange";
    public static final String DB_Driver = "org.h2.Driver";
    public static void main(String[] args) throws IOException {
        Scanner work = new Scanner(System.in);
        StringBuilder bob = new StringBuilder();
        String[] filters = {"name", "country", "city", "age"};
        String[] database = new String[filters.length];
        System.out.println("1. Введите желаемые значения через пробел и в соответствии с параметрами (name, country, city, age): ");
        String put = work.nextLine();
        String[] words = put.split(" ");
        for (int i = 0; i<words.length; i++) {
            bob.append(filters[i]);
            bob.append(":");
            bob.append(words[i]);
            database[i] = bob.toString();
            bob.setLength(0);
        }
        System.out.println(Arrays.toString(database));


        FileWriter w = new FileWriter("DZ2.txt", true);
        PrintWriter writer = new PrintWriter(w);
        writer.print(LocalDateTime.now() + "\n");
        System.out.println("2. Введите желаемый размер массива: ");
        String inp = work.nextLine();
        int si = Integer.parseInt(inp);
        int[] ray = new int[si];
        for (int i = 0; i<si; i++) 
        {
            int randnum = ThreadLocalRandom.current().nextInt(0, 10);
            ray[i] = randnum;
        }
        System.out.println(Arrays.toString(ray) + " - изначальный вид массива");
        writer.print(Arrays.toString(ray) + " - изначальный вид массива\n");
        int temp = 0;
        boolean isSor = false;
        while (!isSor) {
            isSor = true;
            for (int i = 0; i<si-1; i++) {
                if (ray[i]>ray[i+1]) {
                    isSor = false;

                    temp = ray[i];
                    ray[i] = ray[i+1];
                    ray[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ray) + " - сортированный вид массива");
        writer.print(Arrays.toString(ray) + " - сортированный вид массива\n");
        writer.close();

        System.out.println("\n4. Калькулятор! \nДоступные арифметические действия: сложение (+), вычитание (-), умножение (*), деление (/) \nВведите первый аргумент: ");
		String arga = work.nextLine();
		double numa = 0, numb = 0;
		if (arga.chars().allMatch(Character::isDigit)) { numa = Double.parseDouble(arga); }
		else System.out.println("Заданный аргумент не является числом!");
		System.out.println("Укажите желаемое действие: ");
		String opera = work.nextLine();
		System.out.println("Введите второй аргумент: ");
		String argb = work.nextLine();
		if (arga.chars().allMatch(Character::isDigit)) { numb = Double.parseDouble(argb); }
		else System.out.println("Заданный аргумент не является числом!");

        Logger spy = Logger.getLogger(dz.class.getName());
        FileHandler fiha = new FileHandler("log.txt", true);
        spy.addHandler(fiha);

        SimpleFormatter sFormat = new SimpleFormatter();
        fiha.setFormatter(sFormat);

		if (opera.equals("+")) { double res = numa + numb; System.out.println("Ответ: " + res); }
		else if (opera.equals("-")) { double res = numa - numb; System.out.println("Ответ: " + res); }
		else if (opera.equals("*")) { double res = numa * numb; System.out.println("Ответ: " + res); }
		else if (opera.equals("/") && numb != 0) { double res = numa / numb; System.out.println("Ответ: " + res); }
		else { System.out.println("Ошибка!"); spy.log(Level.WARNING, "Something went wrong!"); }
        work.close();

        spy.info("Log");
    }
}