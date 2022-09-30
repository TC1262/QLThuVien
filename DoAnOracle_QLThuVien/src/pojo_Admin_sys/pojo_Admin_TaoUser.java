package pojo_Admin_sys;

public class pojo_Admin_TaoUser {
    private String username,password,default_tablespace,quota,profile,account_status,role,created,last_login;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDefault_tablespace() {
        return default_tablespace;
    }

    public void setDefault_tablespace(String default_tablespace) {
        this.default_tablespace = default_tablespace;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public pojo_Admin_TaoUser() {
        username = password = default_tablespace = quota = profile = 
                account_status = created = last_login = "";
    }

    public pojo_Admin_TaoUser(String username, String password, String default_tablespace, 
            String quota, String profile, String account_status, String role, 
            String created, String last_login) {
        this.username = username;
        this.password = password;
        this.default_tablespace = default_tablespace;
        this.quota = quota;
        this.profile = profile;
        this.account_status = account_status;
        this.role = role;
        this.created = created;
        this.last_login = last_login;
    }
}
