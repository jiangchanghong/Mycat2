package io.mycat.orientserver.handler.data_define;

import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class CreateLogfilegroup {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 2 && list[0].equals("CREATE") && list[1].equals("LOGFILE")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
