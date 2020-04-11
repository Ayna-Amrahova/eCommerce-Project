package DAO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.About;
import model.Home;
import model.Product;
import model.ProductCategory;
import model.User;

public class DB {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_and_shop?useEncoding=true&characterEncoding-UTF8", username, password);
            System.out.println("Database connection has been successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception occured in connection:" + ex.toString());
        }
    }

    public void close() {
        try {
            conn.close();
            ps.close();
            System.out.println("Database connection has been closed!");
        } catch (SQLException ex) {
            System.out.println("Exception occured during close: " + ex.toString());
        }
    }

    public List<ProductCategory> getProductCategories() {
        try {
            List<ProductCategory> list = new ArrayList<>();
            String sql = "select * from product_category";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductCategory pc = new ProductCategory(rs.getInt("id"), rs.getString("category_name"));
                list.add(pc);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ProductCategory getCategorieById(int id) {

        ProductCategory category = new ProductCategory();
        ArrayList<ProductCategory> list = new ArrayList();

        try {
            ps = conn.prepareStatement("SELECT * from product_category where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductCategory pc = new ProductCategory(rs.getInt("id"), rs.getString("category_name"));
                list.add(pc);
            }
            return category;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public List<Product> getProducts(String sortBy) {
        try {
            List<Product> list = new ArrayList<>();
            String sql;

            if (sortBy == null) {
                sql = "select * from products";
            } else {
                sql = "select * from products order by actual_price " + sortBy;
            }
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("category_id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getDouble("actual_price"), rs.getString("info"), rs.getString("img_path"));
                list.add(p);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Product> getProductsByCatId() {
        try {
            List<Product> list = new ArrayList<>();
            String sql;

            sql = "select * from products where id=1||id=7||id=13";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("category_id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getDouble("actual_price"), rs.getString("info"), rs.getString("img_path"));
                list.add(p);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<Product> getAllProductByCategoryId(String categoryId, String sortBy) {
        ArrayList<Product> list = new ArrayList();
        String sql;

        try {
            if (sortBy == null) {
                sql = "select * from products where category_id = ?";
            } else {
                sql = "select * from products where category_id = ? order by actual_price" + sortBy;
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"), rs.getString("category_id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getDouble("actual_price"), rs.getString("info"), rs.getString("img_path"));
                list.add(p);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Product> getSelectedProducts() {
        try {
            List<Product> list = new ArrayList<>();
            String sql = "select * from selected_products";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product s = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("actual_price"));
                list.add(s);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean saveProducts(String name, double actualPrice) {
        try {
            ps = conn.prepareStatement("insert into selected_products(name, actual_price) values (?, ?)");
            ps.setString(1, name);
            ps.setDouble(2, actualPrice);
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;

        }
    }

    public List<About> getAbout() {
        try {
            List<About> list = new ArrayList<>();
            String sql;
            sql = "select * from about";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                About about = new About(rs.getInt("id"), rs.getString("img_path"), rs.getString("paragraph"));
                list.add(about);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean saveContact(String name, String email, String subject, String message) {
        try {
            ps = conn.prepareStatement("insert into contact(name, email, subject, message) values (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, subject);
            ps.setString(4, message);
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;

        }
    }

    public List<Home> getHome() {
        try {
            List<Home> list = new ArrayList<>();
            String sql;
            sql = "select id, img_path, header, paragraph, btn_info from home";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Home home = new Home(rs.getInt("id"), rs.getString("img_path"), rs.getString("header"), rs.getString("paragraph"), rs.getString("btn_info"));
                list.add(home);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Home> getHomeMiddle() {
        try {
            List<Home> list = new ArrayList<>();
            String sql;
            sql = "select id, img_path2, header2, paragraph2 from home";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Home home = new Home(rs.getInt("id"), rs.getString("img_path2"), rs.getString("header2"), rs.getString("paragraph2"));
                list.add(home);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Home> getHomeFooter() {
        try {
            List<Home> list = new ArrayList<>();
            String sql;
            sql = "select id, img_path3 from home";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Home home = new Home(rs.getInt("id"), rs.getString("img_path3"));
                list.add(home);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean saveUser(String username, String password) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(value.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        User user = new User();
        user.setPassword(sb.toString());

        try {
            ps = conn.prepareCall("insert into user (username, password) values (?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            return ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception in saveUser: " + e);
            return false;
        }
    }

    public void checkLogin(String username, String password) {
        try {
            if (username != null && password != null) {
                String sql = "select * from user where username='" + username + "' and password='" + password + "'";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery(sql);
                if (rs.next()) {
                    System.out.println("Login succesfull!");
                } else {
                    System.out.println("Username or password is invalid!");
                }
            }
        } catch (SQLException ex) {
            System.out.println("checkLogin: " + ex);
        }
    }

}
