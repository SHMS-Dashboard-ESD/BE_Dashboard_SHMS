package shmskedaireka.Response;

import java.util.List;
import java.util.Optional;

import shmskedaireka.demo.Models.Bridge;
import shmskedaireka.demo.Models.User;

public class ResponseGetAdminCustomer {
    private Optional<User> user;

    private List<Bridge> bridge;

    public ResponseGetAdminCustomer() {
    }

    public Optional<User> getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }

    public List<Bridge> getBridge() {
        return bridge;
    }

    public void setBridge(List<Bridge> bridge) {
        this.bridge = bridge;
    }

}
