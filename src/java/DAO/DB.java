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
import model.About;
import model.Blog;
import model.Home;
import model.Product;
import model.ProductCategory;
import model.ProductInfo;

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
    
    public List<ProductInfo> getProductInfos() {
        try {
            List<ProductInfo> list = new ArrayList<>();
            String sql = "select * from product_info";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductInfo pc = new ProductInfo(rs.getInt("id"), rs.getString("info"));
                list.add(pc);
            }
            return list;
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
                        rs.getDouble("price"), rs.getDouble("actual_price"), rs.getString("info"), rs.getString("img_path"), rs.getString("info_id"));
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
    
    
    public ArrayList<Product> getAllProductByInfoId(String infoId, String sortBy) {
        ArrayList<Product> list = new ArrayList();
        String sql;

        try {
            if (sortBy == null) {
                sql = "select * from products where info_id = ?";
            } else {
                sql = "select * from products where info_id = ? order by actual_price" + sortBy;
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, infoId);
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
                Product s = new Product(rs.getInt("id"), rs.getString("img_path"), rs.getString("name"), rs.getDouble("actual_price"));
                list.add(s);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean saveProducts(String img_path, String name, double actualPrice) {
        try {
            ps = conn.prepareStatement("insert into selected_products(img_path, name, actual_price) values (?, ?, ?)");
            ps.setString(1, img_path);
            ps.setString(2, name);
            ps.setDouble(3, actualPrice);
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

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        password = sb.toString();

        try {
            ps = conn.prepareCall("insert into user (username, password) values (?,?)");

            ps.setString(1, username);
            ps.setString(2, password);
            return ps.execute();
        } catch (SQLException ex) {
            System.out.println("Save User: " + ex);
            return false;
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

    public boolean saveChat(String msg) {
        try {
            ps = conn.prepareStatement("insert into chat(message) values (?)");
            ps.setString(1, msg);
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public List<Blog> getBlog() {
        try {
            List<Blog> list = new ArrayList<>();
            String sqlComment;
            sqlComment = sqlComment = "SELECT b.id ,b.img_path, b.header , b.text, b.btn_info, b.like_img, c.comment from blog b \n" +
                        "LEFT OUTER join blog_comment c on b.id = c.blog_id \n" +
                        "where (c.id = (select max(c2.id) from blog_comment c2 where c2.blog_id = c.blog_id)\n" +
                        "OR C.COMMENT IS NULL)\n" +
                        ";";
//            sql = "select id, img_path, header, text, btn_info, like_img from blog";
            ps = conn.prepareStatement(sqlComment);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog(rs.getInt("id"), rs.getString("img_path"), rs.getString("header"), 
                        rs.getString("text"), rs.getString("btn_info"), rs.getString("like_img"), rs.getString("comment"));
                list.add(blog);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean saveComment(String comment, int blog_id) {
        try {
            ps = conn.prepareStatement("insert into blog_comment(comment, blog_id) values (?,?)");
            ps.setString(1, comment);
            ps.setInt(2, blog_id);
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
