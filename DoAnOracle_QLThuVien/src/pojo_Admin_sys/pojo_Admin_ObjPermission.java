package pojo_Admin_sys;

public class pojo_Admin_ObjPermission {
    private String grantee, owner, table_name, grantor, privilege, grantable, type;
      // người nhậnn quyền, chủ nhân, tên bảng, người cấp quyền
    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTbName() {
        return table_name;
    }

    public void setTbName(String table_name) {
        this.table_name = table_name;
    }
    
    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }
    
    public String getGrantable() {
        return grantable;
    }

    public void setGrantable(String grantable) {
        this.grantable = grantable;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public pojo_Admin_ObjPermission(String grantee, String owner, 
            String table_name, String grantor, String privilege, String grantable,
            String type) {
        this.grantee = grantee;
        this.owner = owner;
        this.table_name = table_name;
        this.grantor = grantor;
        this.privilege = privilege;
        this.grantable = grantable;
        this.type = type;
    }

    public pojo_Admin_ObjPermission() {
    
        grantee=privilege=owner=table_name=grantor=grantable=type="";
    }

    
    @Override
    public String toString() {
        return "pojo_Admin_ObjPermission{" + "grantee=" + grantee + ", "
                + "owner=" + owner + ", table_name=" + table_name + ", "
                + "grantor=" + grantor + ", privilege=" + privilege + ", "
                + "grantable=" + grantable + ", type=" + type +'}';
    }
}