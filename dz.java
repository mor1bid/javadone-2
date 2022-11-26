import java.util.Scanner;
import java.util.logging.ConsoleHandler;
// import java.lang.System.Logger;
import java.io.IOException;
import java.util.logging.*;
// import java.io.File;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * dz
 */
public class dz {
    public static void main(String[] args) throws IOException {
        Scanner work = new Scanner(System.in);
        System.out.println("2. Введите желаемый размер массива: ");
        String inp = work.nextLine();
        int si = Integer.parseInt(inp);
        int[] ray = new int[si];
        System.out.print("[");
        for (int i = 0; i<si; i++) 
        {
            int randnum = ThreadLocalRandom.current().nextInt(0, 10);
            ray[i] = randnum;
            System.out.print(ray[i] + ", ");
        }
        System.out.print("] - изначальный вид массива\n[");
        int sel = ray[0], temp = 0;
        int[] array = new int[si];
        for (int i = 0; i<si; i++) {
            for (int j = 0; j<si; j++) {
                if (ray[i]<ray[j]) { sel = ray[i]; }
                }
            array[i] = sel;
            System.out.print(ray[i] + ", ");
        }
        System.out.print("] - сортированный вид массива");
        Logger spy = Logger.getLogger(dz.class.getName());
        FileHandler fiha = new FileHandler("log.txt");
        spy.addHandler(fiha);

        SimpleFormatter sFormat = new SimpleFormatter();
        fiha.setFormatter(sFormat);

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

		if (opera.equals("+")) { double res = numa + numb; System.out.println("Ответ: " + res); }
		else if (opera.equals("-")) { double res = numa - numb; System.out.println("Ответ: " + res); }
		else if (opera.equals("*")) { double res = numa * numb; System.out.println("Ответ: " + res); }
		else if (opera.equals("/") && numb != 0) { double res = numa / numb; System.out.println("Ответ: " + res); }
		else { System.out.println("Ошибка!"); spy.log(Level.WARNING, "Something went wrong!"); }
        work.close();

        spy.info("Log");
    }
}