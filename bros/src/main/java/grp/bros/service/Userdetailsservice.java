package grp.bros.service;

import java.util.List;

import grp.bros.model.UserDetails;

public interface Userdetailsservice {
	public boolean validUser(String mid, String pw);
	public void setUser(UserDetails ud);
	public List<UserDetails> getUserById(String id);
}
