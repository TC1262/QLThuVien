package pojo_Admin;

public class pojo_Admin_Statistical {
    private String session_id, db_user, object_schema, object_name, policy_name, 
            sql_text, statement_type;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
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
    
    public pojo_Admin_Statistical(){
        session_id = db_user = object_schema = object_name = policy_name 
                = sql_text = statement_type = "";
    }

    public pojo_Admin_Statistical(String session_id, String db_user, 
            String object_schema, String object_name, String policy_name, 
            String sql_text, String statement_type) {
        this.session_id = session_id;
        this.db_user = db_user;
        this.object_schema = object_schema;
        this.object_name = object_name;
        this.policy_name = policy_name;
        this.sql_text = sql_text;
        this.statement_type = statement_type;
    }  
}