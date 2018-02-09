package com.example.server.DAO;

import com.example.server.DAO.API.ProductPhotoDao;
import com.example.server.entity.ProductPhoto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class ProductPhotoDaoImpl extends mainDao<ProductPhoto> implements ProductPhotoDao {
    private static ProductPhotoDaoImpl productPhotoDao;
    private static RowMapper<ProductPhoto> rowMapper;

    public ProductPhotoDaoImpl() {
        super(new ProductPhoto());
        if (productPhotoDao == null) {
            productPhotoDao = this;
            rowMapper = (ResultSet rs, int conNum) -> {
                ProductPhoto productPhoto = new ProductPhoto();
                productPhoto.setId(rs.getInt("ProductPhotoID"));
                productPhoto.setThumbNailPhoto(rs.getBlob("ThumbNailPhoto").getBytes(1, (int)rs.getBlob("ThumbNailPhoto").length()));
                productPhoto.setThumbnailPhotoFileName(rs.getString("ThumbnailPhotoFileName"));
                productPhoto.setLargePhoto(rs.getBlob("LargePhoto").getBytes(1, (int)rs.getBlob("LargePhoto").length()));
                productPhoto.setLargePhotoFileName(rs.getString("LargePhotoFileName"));
                return productPhoto;
            };
        }
    }

    @Override
    protected RowMapper getRowMapper() {
        return rowMapper;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, ProductPhoto value) throws SQLException {
        String SQL_INSERT = "INSERT INTO productphoto (ThumbNailPhoto, ThumbnailPhotoFileName, LargePhoto, LargePhotoFileName) values (?, ?, ?, ?) ON DUPLICATE KEY UPDATE ThumbnailPhotoFileName = ThumbnailPhotoFileName";
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
        return ps;
    }
}