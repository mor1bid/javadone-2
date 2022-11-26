import java.util.Scanner;
import java.util.logging.ConsoleHandler;
// import java.lang.System.Logger;
import java.io.IOException;
import java.util.logging.*;
// import java.io.File;
import java.io.PrintWriter;

/**
 * dz
 */
public class dz {
    public static void main(String[] args) throws IOException {
        Scanner work = new Scanner(System.in);
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
		else System.out.println("Ошибка!");
        work.close();

        Logger spy = Logger.getLogger(dz.class.getName());
        //ConsoleHandler coha = new ConsoleHandler();
        PrintWriter writer = new PrintWriter("log.txt", "UTF-8");
        FileHandler fiha = new FileHandler("log.txt");
        //spy.addHandler(coha);
        spy.addHandler(fiha);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        //XMLFormatter xml = new XMLFormatter();
        fiha.setFormatter(sFormat);
        //fiha.setFormatter(xml);
        
        //spy.setLevel(Level.INFO);
        spy.log(Level.WARNING, "Тестовое логирование 1");
        spy.info("Тестовое логирование 2");
    }
}