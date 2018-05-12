package grp.bros.dao;

import java.util.List;

import grp.bros.model.UserDetails;

public interface Userdetailsdao {
	public boolean validUser(String mid, String pw);
	public void setUser(UserDetails ud);
	public List<UserDetails> getUserById(String id);
	public void updateAddress(UserDetails ud, String name);
}
