package com.revature.facepaint.dto;



import java.util.Objects;

import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;

public class UserDTO {
    private int id;
    private String username;
    private Role role;
    private String imageID;

    public UserDTO(){
        super();
    }

    public UserDTO(User u){
        id = u.getId();
        username = u.getUsername();
        role = u.getRole();
        imageID = u.getImageID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageId) {
        this.imageID = imageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && username.equals(userDTO.username) && role == userDTO.role && Objects.equals(imageID, userDTO.imageID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role, imageID);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", imageId='" + imageID + '\'' +
                '}';
    }
}
