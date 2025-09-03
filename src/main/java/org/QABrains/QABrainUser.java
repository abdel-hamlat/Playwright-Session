package org.QABrains;

public class QABrainUser {
    private final String email;
    private final String password;

    public QABrainUser() {
        this.email = "qa_testers@qabrains.com";
        this.password = "Password123";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
