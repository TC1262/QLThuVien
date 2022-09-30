package pojo_Admin_sys;

public class pojo_Admin_Profile {
    private String profile, resource_name, resource_type, limit, common;

    // Phím tắt lệnh get/set: Alt + Insert
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
    
    public pojo_Admin_Profile(String profile, String resource_name, 
            String resource_type, String common) {
        this.profile = profile;
        this.resource_name = resource_name;
        this.resource_type = resource_type;
        this.common = common;
    }

    public pojo_Admin_Profile() {
    
        profile=resource_name=resource_type=common="";
    }

    @Override
    public String toString() {
        return "pojo_Admin_Profile{" + "profile=" + profile + ", "
                + "resource_name=" + resource_name + ", "
                + "resource_type=" + resource_type + ", "
                + "common=" + common +'}';
    }
}