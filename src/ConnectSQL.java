import java.sql.*;
import java.util.Scanner;

public class ConnectSQL {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "0903302271";

        try {
            Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Kết nối thành công với postgresSQL");

            Scanner sc = new Scanner(System.in);
            String name, nickname, general_type;
            int level;
            int choice;
            while (1 < 2)
            {
                System.out.println("1-Thêm dữ liệu");
                System.out.println("2-Xem dữ liệu");
                System.out.println("0-Dừng chương trình");
                System.out.print("Nhập lựa chọn: ");
                choice = sc.nextInt();
                if (choice == 1)
                {
                    System.out.println("|====Nhập thông tin tướng====|");
                    sc.nextLine();
                    System.out.print("Tên tướng: ");
                    name = sc.nextLine();
                    System.out.print("Biệt danh: ");
                    nickname = sc.nextLine();
                    System.out.print("Loại tướng: ");
                    general_type = sc.nextLine();
                    System.out.print("Độ khó tướng: ");
                    level = sc.nextInt();

                    String insert = "INSERT INTO \"Champion\" (name, nickname, general_type, level)\n";
                    String values = "VALUES('" + name + "','" + nickname + "','" + general_type + "'," + level + ")";
                    String sql = insert + values;
                    Statement statement = connection.createStatement();
                    int row = statement.executeUpdate(sql);
                    if  (row > 0 ) System.out.println("Thêm dữ liệu thành công");

                    System.out.println(sql);
                }
                if (choice == 2)
                {
                    String sql = "SELECT * FROM \"Champion\"";
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);
                    System.out.println("NAME - NICKNAME - GENERAL_TYPE - LEVEL");
                    while (result.next())
                    {
                        name = result.getString("name");
                        nickname = result.getString("nickname");
                        general_type = result.getString("general_type");
                        level = result.getInt("level");
                        System.out.printf("%s - %s - %s - %d \n", name, nickname, general_type, level);
                    }
                }
                if(choice == 0)
                {
                    connection.close();
                    System.out.println("Kết thúc chương trình");
                    break;
                }

            }
        } catch (SQLException e) {
            System.out.print("Kết nối lỗi");
            e.printStackTrace();
        }

    }
}
