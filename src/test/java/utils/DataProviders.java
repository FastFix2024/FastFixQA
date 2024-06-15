package utils;

import dto.UserDTO;
import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    private static List<Object[]> readCSVData(String filePath, int numberOfColumns) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        List<Object[]> userData = new ArrayList<>();
        String line = in.readLine();
        while ((line = in.readLine()) != null) {
            String[] fields = line.split(",");
            UserDTO user = getUserDTO(numberOfColumns, fields);
            userData.add(new Object[]{user});
        }
        in.close();
        return userData;
    }

    private static UserDTO getUserDTO(int numberOfColumns, String[] fields) {
        UserDTO user = new UserDTO();
        if (numberOfColumns == 4) {
            user.setUsername(fields[0]);
            user.setEmail(fields[1]);
            user.setPassword(fields[2]);
            user.setConfirmPassword(fields[3]);
        } else if (numberOfColumns == 2) {
            user.setEmail(fields[0]);
            user.setPassword(fields[1]);
        } else {
            throw new IllegalArgumentException("Unsupported number of columns");
        }
        return user;
    }

    @DataProvider(name = "positiveRegistrationData")
    public static Iterator<Object[]> positiveRegistrationData() throws IOException {
        return readCSVData("src/test/resources/positiveregistrationdata.csv",4).iterator();
    }
    @DataProvider(name = "negativeUsernameRegistrationData")
    public static Iterator<Object[]> negativeUsernameRegistrationData() throws IOException {
        return readCSVData("src/test/resources/negusernameregistrationdata.csv",4).iterator();
    }
    @DataProvider(name = "negativeMailRegistrationData")
    public static Iterator<Object[]> negativeMailRegistrationData() throws IOException {
        return readCSVData("src/test/resources/negmailregistrationdata.csv",4).iterator();
    }
    @DataProvider(name = "negativePasswordRegistrationData")
    public static Iterator<Object[]> negativePasswordRegistrationData() throws IOException {
        return readCSVData("src/test/resources/negpassregistrationdata.csv",4).iterator();
    }

    @DataProvider(name = "positiveLoginData")
    public static Iterator<Object[]> positiveLoginData() throws IOException {
        return readCSVData("src/test/resources/positivelogindata.csv",2).iterator();
    }

    @DataProvider(name = "negativeMailLoginData")
    public static Iterator<Object[]> negativeMailLoginData() throws IOException {
        return readCSVData("src/test/resources/negmaillogindata.csv",2).iterator();
    }
    @DataProvider(name = "negativePasswordLoginData")
    public static Iterator<Object[]> negativePasswordLoginData() throws IOException {
        return readCSVData("src/test/resources/negpasslogindata.csv",2).iterator();
    }
}
