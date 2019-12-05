import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> todoList = new ArrayList<>();

        while(true) {
            String str = reader.readLine();
            if(str.equals("EXIT")){
                break;
            }
            else if(str.matches("ADD\\s\\D+.+")){
                String deal = str.substring(str.lastIndexOf("ADD")+4);
                todoList.add(deal);
            }
            else if(str.matches("ADD\\s\\d+\\s\\D+.+")){
                Pattern pattern = Pattern.compile("\\s+");
                String[] strings = pattern.split(str, 3);
                int index = Integer.parseInt(strings[1].trim());
                String deal = str.substring(str.indexOf(strings[2]));
                if (index <= todoList.size()) {
                    todoList.add(index ,deal);
                } else {
                    System.out.println("Number of List is incorrect");
                }
            }
            else if(str.matches("EDIT\\s\\d+\\s\\D+.+")){
                Pattern pattern = Pattern.compile("\\s+");
                String[] strings = pattern.split(str, 3);
                int index = Integer.parseInt(strings[1].trim());
                String deal = str.substring(str.indexOf(strings[2]));
                if (index < todoList.size()) {
                    todoList.set(index, deal);
                } else {
                    System.out.println("Number of List is incorrect");
                }
            }
            else if(str.matches("DELETE\\s\\d+")){
                Pattern pattern = Pattern.compile("\\s+");
                String[] strings = pattern.split(str, 2);
                int index = Integer.parseInt(strings[1].trim());
                if (index < todoList.size()) {
                    todoList.remove(index);
                } else {
                    System.out.println("Number of List is incorrect");
                }
            }
            else if(str.equals("LIST")){
                for(int i = 0; i < todoList.size(); i++){
                    System.out.println(i + " " + todoList.get(i));
                }
            }
        }
        reader.close();
    }
}

