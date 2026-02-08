package com.student;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static java.time.chrono.JapaneseEra.values;

public class StudentDAO {
    public static void addStudent(String name, String email, String course) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO Students(name,email,course) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.executeUpdate();// es option kam ye check karna table naam aor code jo table naam same he ya nhi2

            System.out.println("Student Added Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(int id, String course) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE students SET course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, course);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Student Updated Successfully");
            else
                System.out.println("❌ Student ID not found");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Student Deleted Successfully");
            else
                System.out.println("❌ Student ID not found");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email") + " " +
                                rs.getString("course")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







