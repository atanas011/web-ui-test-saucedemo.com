package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

    private static final List<User> users = getDataFromXlsx();

    public static String getUsername(int userIndex) {
        return users.get(userIndex).username();
    }

    public static String getPassword(int userIndex) {
        return users.get(userIndex).password();
    }

    private static List<User> getDataFromXlsx() {
        var file = new File("data.xlsx");
        List<User> users = new ArrayList<>();

        try {
            var inputStream = new FileInputStream(file);
            var workbook = new XSSFWorkbook(inputStream);
            var sheet = workbook.getSheet("user-data");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip the 1st row (tbl headers)
                var row = sheet.getRow(i);
                var userCell = row.getCell(0);
                var passCell = row.getCell(1);
                users.add(new User(userCell.toString(), passCell.toString()));
            }

//            for (User user : users)
//                System.out.println("Username: " + user.username() + " | Password: " + user.password());

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private record User(String username, String password) {
        // a class converted to a record
    }
}