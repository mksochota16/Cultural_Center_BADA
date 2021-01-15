package bada_proi.entity;

import org.springframework.lang.Nullable;

public class AppUser {
    private int userId;
    private String username;
    private String encryptedPassword;
    private int enabled; //TODO check if boolean works
    @Nullable
    private Integer participantId;
    @Nullable
    private Integer guardianId;
    @Nullable
    private Integer employeeId;

    public AppUser() {
    }

    public AppUser(int userId, String username, String encryptPassword, int enabled, Integer participantId, Integer guardianId, Integer employeeId) {
        this.userId = userId;
        this.username = username;
        this.encryptedPassword = encryptPassword;
        this.enabled = enabled;
        this.participantId = participantId;
        this.guardianId = guardianId;
        this.employeeId = employeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Integer guardianId) {
        this.guardianId = guardianId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", encryptPassword='" + encryptedPassword + '\'' +
                ", enabled=" + enabled +
                ", participantId=" + participantId +
                ", guardianId=" + guardianId +
                ", employeeId=" + employeeId +
                '}';
    }
}