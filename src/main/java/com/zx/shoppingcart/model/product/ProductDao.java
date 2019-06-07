package com.zx.shoppingcart.model.product;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class ProductDao {
    private Statement statement;

    public ProductDao(Statement statement) {
        this.statement = statement;
    }


    public Product getById(int id) throws SQLException {

            //构造查询语句
            String query = "SELECT * FROM 'product' WHERE id=" + id;
            ResultSet rs = statement.executeQuery(query);

            //根据查询结果构造Product对象
            if(rs.next()){
                return new Product(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("description"),
                  rs.getDouble("price")
                );
            }

            return null;
    }

    public ArrayList<Product> list() throws SQLException {

        ArrayList<Product> products = new ArrayList<>();

            //构造查询语句
            String query = "SELECT * FROM 'product'";
            ResultSet rs = statement.executeQuery(query);

            //根据查询结果构造Product对象
            while(rs.next()){
                 products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                ));
            }

            return products;
    }

    public Product create(Product product) throws SQLException {
        String sql = "INSERT INTO 'product' VALUES ("+
                            product.getId() + ',' +
                            '"' + product.getName() + '"' +',' +
                            '"' +product.getDescription()+'"' +','+
                            product.getPrice() +")" ;

        //System.out.println(sql);

        statement.executeUpdate(sql);
        return product;
    }

    public Product update(Product product) throws SQLException {
        String sql = "UPDATE 'product' SET " +
                     "name=" + "'"+product.getName()+"',"+
                     "description=" + "'" + product.getDescription() + "'," +
                     "price=" + product.getPrice()  +
                     " WHERE id=" + product.getId() ;

        //System.out.println(sql);

        statement.executeUpdate(sql);
        return product;
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM 'product' WHERE ID = " + id;
        statement.executeUpdate(sql);
    }
}
