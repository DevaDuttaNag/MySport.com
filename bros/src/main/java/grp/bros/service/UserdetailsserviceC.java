package grp.bros.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import grp.bros.dao.Userdetailsdao;
import grp.bros.model.UserDetails;
@Service
public class UserdetailsserviceC implements Userdetailsservice {
	
	@Autowired
	Userdetailsdao uddao;
	public boolean validUser(String mid,String pw) {
		if(uddao.validUser(mid,pw)==true)
			return true;
			else 
				return false;	}

	public void setUser(UserDetails ud) {
		uddao.setUser(ud);
		saveimage(ud.getImagefile(),ud.getMid());
		
	}

	private void saveimage(MultipartFile image, String mid) {
		Path path=Paths.get("F://dev//bros//src//main//webapp//resources//images//users//"+mid+".jpg");
		try
		{if(image!=null && !image.isEmpty())
		{
			System.out.println("\npath :" + path.toString());
			image.transferTo(new File(path.toString()));
			System.out.println("image saved check it");
		}
		}
		catch(Exception e){
		System.out.println("image not saved"+e);	
			
		}
	}

	public List<UserDetails> getUserById(String id) {
		List<UserDetails> l=uddao.getUserById(id);
		return l;
	}

}
