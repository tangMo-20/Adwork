package com.example.server.DAO;

import com.example.server.DAO.API.TransactionHistoryArchiveDao;
import com.example.server.entity.TransactionHistoryArchive;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class TransactionHistoryArchiveDaoImpl extends mainDao<TransactionHistoryArchive> implements TransactionHistoryArchiveDao {
    private static TransactionHistoryArchiveDaoImpl transactionHistoryArchiveDao;
    private static RowMapper<TransactionHistoryArchive> rowMapper;

    public TransactionHistoryArchiveDaoImpl() {
        super(new TransactionHistoryArchive());
        if (transactionHistoryArchiveDao == null) {
            transactionHistoryArchiveDao = this;
            rowMapper = (ResultSet rs, int conNum) -> {
                TransactionHistoryArchive transactionHistoryArchive = new TransactionHistoryArchive();
                transactionHistoryArchive.setTransactionID(rs.getInt("TransactionID"));
                transactionHistoryArchive.setProductID(rs.getInt("ProductID"));
                return transactionHistoryArchive;
            };
        }
    }

    public static synchronized TransactionHistoryArchiveDaoImpl getInstance() {
        if (transactionHistoryArchiveDao == null) {
            transactionHistoryArchiveDao = new TransactionHistoryArchiveDaoImpl();
        }
        return transactionHistoryArchiveDao;
    }

    @Override
    protected RowMapper getRowMapper() {
        return rowMapper;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, TransactionHistoryArchive value) throws SQLException {
        String SQL_INSERT = "INSERT INTO transactionhistoryarchive (ThumbNailPhoto, ThumbnailPhotoFileName, LargePhoto, LargePhotoFileName) values (?, ?, ?, ?) ON DUPLICATE KEY UPDATE ThumbnailPhotoFileName = ThumbnailPhotoFileName";
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
//        ps.setBlob(1, value.getThumbNailPhoto());
//        ps.setString(2, value.getLargePhotoFileName());
//        ps.setBlob(3, value.getLargePhoto());
//        ps.setString(4, value.getLargePhotoFileName());
        return ps;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, TransactionHistoryArchive value) throws SQLException {
        String SQL_UPDATE = "UPDATE transactionhistoryarchive SET ThumbNailPhoto = ?, ThumbnailPhotoFileName = ?, LargePhoto = ?, LargePhotoFileName = ? WHERE ProductPhotoID = ?";
        PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
//        ps.setBlob(1, value.getThumbNailPhoto());
//        ps.setString(2, value.getLargePhotoFileName());
//        ps.setBlob(3, value.getLargePhoto());
//        ps.setString(4, value.getLargePhotoFileName());
//        ps.setInt(5, value.getId());
        return ps;
    }
}