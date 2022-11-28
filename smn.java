import java.io.File;

public class smn {
    public static void main(String[] args) {
        getArray("C:\\Users\\De\\Desktop\\osjunkyard\\gb\\ZsYP\\Java\\II");
    }
    public static void getArray(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] ray = file.list();
            for (int i = 0; i< ray.length; i++) {
                System.out.printf(ray[i] + "\n");
                File elif = new File(str + "\\" + ray[i]);
                if (elif.isDirectory()) {
                    getArray(file.getPath() + String.format("\\%s", ray[i]));
                }
            }
        }
    }
}
