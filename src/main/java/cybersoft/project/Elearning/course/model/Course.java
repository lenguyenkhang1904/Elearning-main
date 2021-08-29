package cybersoft.project.Elearning.course.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.Review.model.Review;
import cybersoft.project.Elearning.Video.Model.Video;

import cybersoft.project.Elearning.user.model.User;
import cybersoft.project.Elearning.user.model.UserBought;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Course_Elearning")
@Getter
@Setter
public class Course extends AbstractEntity {
	
	@Column(unique = true)
	private String codeCourse;
	
	
	private Double price;
	
	
	private String aliasCourse;
	
	
	private String description;
	
	
	private int view;
	
	
	private String display;
	
	
	private int noOfLearner;
	
	private int discount;
	
	private int hour_count;
	
	private String codeValidator;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private CourseCategory courseCategory;
	
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "User_Course_Elearing",joinColumns = @JoinColumn(name="id_User"),inverseJoinColumns = @JoinColumn(name="id_Course"))
	private Set<User> creators=new HashSet<>();
	
	
	

	
	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private Set<Review> reviews=new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Video video;
	

	
	
	 @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	 @JoinTable(name = "UserBought_Course_Elearing",joinColumns = @JoinColumn(name="id_UserBought"),inverseJoinColumns = @JoinColumn(name="id_Course"))
	 private Set<UserBought> learners=new HashSet<>();
	 
	
	
	
	public Course addLearners(UserBought bought)
	{
		this.learners.add(bought);
		bought.getCourses().add(this);
		return this;
	}
	
	
	public Course addUser(User user)
	{
		this.creators.add(user);
		user.getCourse().add(this);
		return this;
	}
	
	
	
	
}
