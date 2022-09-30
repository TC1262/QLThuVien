/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo_Admin_sys;

/**
 *
 * @author DELL
 */
public class pojo_Admin_GiamSat {
    private  String timestamp,db_user,userhost,object_schema,object_name,policy_name,sql_text,statement_type;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getUserhost() {
        return userhost;
    }

    public void setUserhost(String userhost) {
        this.userhost = userhost;
    }

    public String getObject_schema() {
        return object_schema;
    }

    public void setObject_schema(String object_schema) {
        this.object_schema = object_schema;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public String getSql_text() {
        return sql_text;
    }

    public void setSql_text(String sql_text) {
        this.sql_text = sql_text;
    }

    public String getStatement_type() {
        return statement_type;
    }

    public void setStatement_type(String statement_type) {
        this.statement_type = statement_type;
    }

    public pojo_Admin_GiamSat(String timestamp, String db_user, String userhost, String object_schema, String object_name, String policy_name, String sql_text, String statement_type) {
        this.timestamp = timestamp;
        this.db_user = db_user;
        this.userhost = userhost;
        this.object_schema = object_schema;
        this.object_name = object_name;
        this.policy_name = policy_name;
        this.sql_text = sql_text;
        this.statement_type = statement_type;
    }

    @Override
    public String toString() {
        return "pojo_Admin_GiamSat{" + "timestamp=" + timestamp + ", db_user=" + db_user + ", userhost=" + userhost + ", object_schema=" + object_schema + ", object_name=" + object_name + ", policy_name=" + policy_name + ", sql_text=" + sql_text + ", statement_type=" + statement_type + '}';
    }
    
}
