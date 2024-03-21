package com.jsp.ProductEntity.entity;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull(message = "Invalid UserName!!!")
	private String userName;
	@NotNull(message = "Invalid UserMail!!!")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message ="Invalid Email Format!!!")
	private String userEmail;
	@NotNull(message = "Invalid UserPhoneNumber!!!")
	@Min(value = 6000000000l,message="Invalid Phone Number!!!")
	@Max(value = 9999999999l,message="Invalid Phone Number!!!")
	private long userPhoneNumber;
	@NotNull(message = "Invalid UserPassword!!!")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",message= "Invalid Password Format!!!")
	private String userPassword;

}
