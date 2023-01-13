package com.java.mysql;



import java.sql.*;
import java.util.Scanner;
//有个bug改不了 问了好几个管理员最后的table会提示不存在数据库链接是成功的
public class Conn { // 创建类Conn
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                switch (function()) {
                    case 1:
                        System.out.println("choose 1 select all students or 2 select all classes");
                        select(scanner.nextInt());
                        break;
                    case 2:
                        insert();
                        break;
                    case 3:
                        System.out.println("input the id which you want to change:");
                        update(scanner.nextInt());
                        break;
                    case 4:
                        System.out.println("input the id which you want to delete:");
                        delete(scanner.nextInt());
                        break;
                    case 5:
                        System.out.println("input the classid which you want to change:");
                        updateClassID(scanner.nextInt());
                        break;
                    default:
                        System.err.println("Please select from 1-5");
                }
            }
        }

        public static int function() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to management System");
            System.out.println("Enter 1 to query student information");
            System.out.println("Enter 2 to insert a new student");
            System.out.println("Enter 3 to update a student");
            System.out.println("Enter 4 to delete a new student");
            System.out.println("Enter 5 to update a class");
            System.out.println("Now you can pick a number\n:");
            return scanner.nextInt();
        }

        public static Connection connectDatabase() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");//csdn上的格式
            String url = "jdbc:mysql://localhost:3306/management system?useUnicode=true&characterEncoding=utf8&uesSSL=true";
            String user = "root";
            String password = "kjy030228";
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }

        public static void select(int function2) throws ClassNotFoundException, SQLException {
            Connection con = connectDatabase();
            Statement statement = con.createStatement();
            if (function2 == 1) {
                String sql = "SELECT * FROM students";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println("id=" + resultSet.getObject("id"));
                    System.out.println("name=" + resultSet.getObject("name"));
                    System.out.println("sex=" + resultSet.getObject("sex"));
                }
            } else if (function2 == 2) {
                String sql = "SELECT * FROM class";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println("classid=" + resultSet.getObject("classid"));
                    System.out.println("studentmessage=" + resultSet.getObject("studentmessage"));
                    System.out.println("time=" + resultSet.getObject("time"));
                }
            } else {
                System.err.println("Please select from 1-2");
            }
        }

        public static void insert() throws ClassNotFoundException, SQLException {
            Connection connection = connectDatabase();
            String sql1 = "insert into `students` values (?,?,?)";
            String sql2 = "insert into `class` values (?,?,?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            Scanner sca = new Scanner(System.in);

            System.out.println("input the id of new student:");
            int id = sca.nextInt();
            preparedStatement1.setInt(1, id);
            System.out.println("input the name of new student:");
            String name = sca.next();
            preparedStatement1.setString(2, name);
            System.out.println("input the sex of new student:");
       //先对sql的占位符赋值



            // preparedStatement1.setInt(2, classid);

            //   preparedStatement2.setInt(3, id);

            String sex = sca.next();
            preparedStatement1.setString(3, sex);
            boolean flag = (!sex.equals("男") || !sex.equals("女"));
            if (flag) {

            }
            System.out.println("input the classid of new student:");
            int classid = sca.nextInt();
            preparedStatement2.setInt(1, classid);
            System.out.println("input the coming time:");
            Time time = new Time(System.currentTimeMillis());
            preparedStatement2.setTime(2, time);

            if (preparedStatement1.executeUpdate() == 1 && preparedStatement2.executeUpdate() == 1) {
                System.out.println("Successful inserted!");
            } else {
                System.out.println("Fail to insert");
            }
        }

        public static void update(int sid) throws ClassNotFoundException, SQLException {
            Connection connection = connectDatabase();
            String sql = "update `students` set id=?,name=?,sex=? where id=" + sid;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Scanner sca = new Scanner(System.in);

            System.out.println("input the new id of the student:");
            int id = sca.nextInt();
            System.out.println("input the new name of the student:");
            String name = sca.next();
            System.out.println("input the new sex of the student:");
            String sex = sca.next();
          //  System.out.println("input the new classid of the student:");
         //   int classid = sca.nextInt();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, sex);
        //    preparedStatement.setInt(4, classid);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Successful updated!");
            } else {
                System.out.println("Fail to update");
            }
        }


        public static void delete(int sid) throws ClassNotFoundException, SQLException {
            Connection connection = connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from `class` where SID=" + sid);
            if (preparedStatement.executeUpdate() == 0) {
                System.out.println("The student is not in the this class");
            } else {
                System.out.println("Successful deleted!");
            }
        }

        public static void updateClassID(int cid) throws ClassNotFoundException, SQLException {
            Connection connection = connectDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement("update `students` set classid=? where classid=" + cid);
            Scanner scanner = new Scanner(System.in);

            System.out.println("input the classid of the class:");
            int classid = scanner.nextInt();

            preparedStatement.setInt(1, classid);
            preparedStatement.executeUpdate();
        }

    }


