import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("https://dummy-json.mock.beeceptor.com/todos");
            URLConnection urc = url.openConnection();
            urc.connect();

            InputStream inputStream = urc.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String res = bufferedReader.readLine();

            Controller controller = new Controller();
            while(res!=null){
                controller.setToDos(res);
                res = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            System.out.println("In which format you want to see the tasks? User/task");
            Scanner sc = new Scanner(System.in);
            res = sc.nextLine();
            sc.close();

            switch (res) {
                case "user":
                    controller.setUserPrint(true);
                    break;
                case "task":
                    controller.setUserPrint(false);
                    break;
                default:
                    break;
            }

            controller.printAll();

        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
