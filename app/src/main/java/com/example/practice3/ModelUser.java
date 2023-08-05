package com.example.practice3;

public class ModelUser {


    String docId, userName, lastMsg,profile;

    public ModelUser(String docId, String userName, String lastMsg, String profile) {
        this.docId = docId;
        this.userName = userName;
        this.lastMsg = lastMsg;
        this.profile = profile;
    }


    public ModelUser(String userName, String lastMsg) {
        this.userName = userName;
        this.lastMsg = lastMsg;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }
}
