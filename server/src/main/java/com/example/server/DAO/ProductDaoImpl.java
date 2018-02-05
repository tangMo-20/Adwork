package com.example.server.DAO;

import com.example.server.DAO.API.*;
import com.example.server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl extends mainDao<Product> implements ProductDao {

    @Autowired
    private ProductPhotoDao productPhotoDao;
    //private ProductPhotoDao productPhotoDao;

    private static ProductDaoImpl productDaoImpl;
    private static RowMapper<Product> rowMapper;
    private final String SQL_GET_PHOTOS = "SELECT ProductPhotoID FROM productproductphoto WHERE ProductID = ?";

    protected ProductDaoImpl() {
        super(new Product());
        if (productDaoImpl == null) {
            productDaoImpl = this;
            rowMapper = (ResultSet rs, int conNum) -> {
                Product product = new Product();
                product.setId(rs.getInt("ProductID"));
                product.setName(rs.getString("Name"));
                product.setProductNumber(rs.getString("ProductNumber"));
                product.setProductNumber(rs.getString("ProductNumber"));
                product.setColor(rs.getString("Color"));
                product.setListPrice(rs.getDouble("ListPrice"));
                product.setProductSize(rs.getString("Size"));
                product.setProductWeight(rs.getDouble("Weight"));
                product.setProductLine(rs.getString("ProductLine"));
                product.setProductClass(rs.getString("Class"));
                product.setProductStyle(rs.getString("Style"));

                List<Integer> photoPhotoIDList = this.jdbcTemplate.queryForList(SQL_GET_PHOTOS, new Object[] {product.getId()}, Integer.class);
                List<ProductPhoto> productPhotos = new ArrayList<>();
                for (Integer id : photoPhotoIDList) {
                    productPhotos.add(productPhotoDao.read(id));
                }
                product.setProductPhotos(productPhotos);
                return product;
            };
        }
    }

    public static synchronized ProductDaoImpl getInstance() {
        if (productDaoImpl == null) {
            productDaoImpl = new ProductDaoImpl();
        }
        return productDaoImpl;
    }

    @Override
    public List<Product> getInStock() {
        String SQL_GET_NOT_NULL = "SELECT * FROM product WHERE FinishedGoodsFlag = 1";
        return jdbcTemplate.query(SQL_GET_NOT_NULL, getRowMapper());
    }

    @Override
    public List<Product> getAll() {
        String SQL_GET_ALL = "SELECT * FROM product";
        return jdbcTemplate.query(SQL_GET_ALL, getRowMapper());
    }

    @Override
    protected RowMapper getRowMapper() {
        return rowMapper;
    }

    @Override
    public List<Product> getTopFive() {
        String SQL_GET_TOP_FIVE = "SELECT * FROM product \n" +
                "JOIN transactionhistoryarchive ON product.ProductID = transactionhistoryarchive.ProductID \n" +
                "JOIN productsubcategory ON product.ProductSubcategoryID = productsubcategory.ProductSubcategoryID \n" +
                "WHERE productsubcategory.ProductCategoryID = 1 GROUP BY product.ProductID ORDER BY count(*) DESC LIMIT 5";
        return jdbcTemplate.query(SQL_GET_TOP_FIVE, getRowMapper());
    }

    @Override
    public List<Product> searchProduct(String searchRequest) {
        String SQL_SEARCH = "SELECT * FROM product WHERE Name LIKE \"%%%s%%\"";
        String sql = String.format(SQL_SEARCH, searchRequest);
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public Integer create(Product value) {
        Integer id = super.create(value);
//        for (Illustration illustration : value.getIllustrations()) {
//        }
        return id;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Product value) throws SQLException {
        String SQL_INSERT = "INSERT INTO product (Name, rowguid) values (?, ?) ON DUPLICATE KEY UPDATE Name = Name";
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, value.getName());
//        ps.setString(2, value.getCatalogDescription());
//        ps.setString(3, value.getInstruction());
//        ps.setString(4, value.getRowguid());
        return ps;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Product value) throws SQLException {
        String SQL_UPDATE = "UPDATE product SET Name = ?, rowguid = ? WHERE ProductModelID = ?";
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
        ps.setString(1, value.getName());
        ps.setInt(2, value.getId());
//        ps.setString(2, value.getCatalogDescription());
//        ps.setString(3, value.getInstruction());
//        ps.setString(4, value.getRowguid());
//        ps.setInt(5, value.getId());
        return ps;
    }
}

