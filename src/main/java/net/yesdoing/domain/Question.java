package net.yesdoing.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_question_writer"))
	User writer;
	@Column(nullable=false, length=100)
	private String title;
	@Column(nullable=false)
	private String contents;
	private LocalDateTime createDate;
	
	
	public String getFormattedCreateDate() {
		if (createDate == null) {
			return ""; 
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}

	public Question() {
	}
	
	public Question(User writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
	}

	public User getWriter() {
		return writer;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public boolean matchUser(User sessionUser) {
		if(sessionUser == null) {
			return false;
		}
		return sessionUser.equals(writer);
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	
	
}
