package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.statement.SQLInsertStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class Minsert {
    public static void handle(SQLInsertStatement x, OConnection connection) {
        if (DBadapter.currentDB == null) {
            connection.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "没有选择数据库");
        }
        try {
            DBadapter.getInstance().exesql(x.toString());
            connection.writeok();
        } catch (MException e) {
            e.printStackTrace();
            connection.writeErrMessage(e.getMessage());
        }
    }
}
