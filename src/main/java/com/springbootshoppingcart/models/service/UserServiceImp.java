package com.springbootshoppingcart.models.service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Address;
import com.springbootshoppingcart.models.entity.Customer;
import com.springbootshoppingcart.models.entity.Rol;
import com.springbootshoppingcart.models.entity.User;
import com.springbootshoppingcart.models.repository.IAddressRepository;
import com.springbootshoppingcart.models.repository.ICustomerRepository;
import com.springbootshoppingcart.models.repository.IRolRepository;
import com.springbootshoppingcart.models.repository.IUserRepository;
import com.springbootshoppingcart.security.Utility;

import net.bytebuddy.utility.RandomString;
@Service
public class UserServiceImp implements IUserService{
    @Autowired
    private IRolRepository irolrepo;
    @Autowired
    private ICustomerRepository icusterrepo;
    @Autowired
    private IUserRepository iuserrepo;
    @Autowired
    private IAddressRepository iaddressrepo;
    @Autowired
    private PasswordEncoder passEncoder;
    @Autowired JavaMailSender mailSender;
   
	@Override
	@Transactional
	public void signupUser(User user, Customer customer, Address address, String siteUrl) 
			//throws UnsupportedEncodingException, MessagingException 
	{
		Rol rol = irolrepo.findByName("CUSTOMER");
		//convertir una clase en Set. Set es una interface -> HasSet para instanciar
		Set<Rol> roles = new HashSet<Rol>(Arrays.asList(rol));
		user.setRoles(roles);
		user.setPassword(Utility.passEncoder().encode(user.getPassword()));
		iuserrepo.save(user);
		customer.setUser(user);
		icusterrepo.save(customer);
		address.setCustomer(customer);
		iaddressrepo.save(address);
		
	}

    
	@Override
	@Transactional(readOnly=true)
	public String uniqueMail(String mailId) {
		User userMail = iuserrepo.findByMail(mailId);
		return (userMail==null) ? "Unic" : "Duplicate";
	}


	@Override
	public void sendVerificationEmail(User user, String siteURL) 
			 throws MessagingException, UnsupportedEncodingException 
	{
	    String toAddress = user.getMail();
	   // String fromAddress = "Your email address";
	    String senderName = "Your company name";
	    String subject = "Please verify your registration";
	    String content = 
	             "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "Your company name.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    //helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    String verifyURL = siteURL + "/verify?code=" + user.getVerificateCode();
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	     
	}
	
	@Override
	public void register(User user, String siteURL) 
			throws UnsupportedEncodingException, MessagingException {
	    String encodedPassword = passEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    String randomCode = RandomString.make(64);
	    user.setVerificateCode(randomCode);
	    user.setStatus(false);
	     
	    iuserrepo.save(user);
	     
	    sendVerificationEmail(user, siteURL);
	}
	
     
}
