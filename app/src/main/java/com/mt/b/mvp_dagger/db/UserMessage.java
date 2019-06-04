package com.mt.b.mvp_dagger.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
@Entity
public class UserMessage {
    @Id(autoincrement = true)
    private Long mainId;   //主键
    @Property(nameInDb = "user_name")
    private String user_name;        //账号
    @Property(nameInDb = "password")
    private String password;        //密码
    @Generated(hash = 1455143480)
    public UserMessage(Long mainId, String user_name, String password) {
        this.mainId = mainId;
        this.user_name = user_name;
        this.password = password;
    }
    @Generated(hash = 113828295)
    public UserMessage() {
    }
    public Long getMainId() {
        return this.mainId;
    }
    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }
    public String getUser_name() {
        return this.user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
