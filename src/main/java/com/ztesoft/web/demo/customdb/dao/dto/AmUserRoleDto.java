package com.ztesoft.web.demo.customdb.dao.dto;

import com.ztesoft.web.demo.db.po.AmUserRolePO;

public class AmUserRoleDto extends AmUserRolePO {

    private String state;

    private String nickName;

    private String telephone;

    private String email;

    private String userName;

    private String roleName;

    private String comments;

    private Integer roleId;

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return Returns the state.<br>
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state to set. <br>
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return Returns the nickName.<br>
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName The nickName to set. <br>
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return Returns the telephone.<br>
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone The telephone to set. <br>
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return Returns the email.<br>
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email to set. <br>
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
