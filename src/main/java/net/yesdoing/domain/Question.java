package net.yesdoing.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_question_writer"))
	User writer;
	
	private String title;
	
	@Lob
	private String contents;
	
	@JsonProperty
	private Integer countOfAnswer = 0;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy="question")
	@OrderBy("id DESC")
	@JsonBackReference
	private List<Answer> answers;
	
	public List<Answer> getAnswers() {
		return answers;
	}

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
	
	public Integer getCountOfAnswer() {
		return countOfAnswer;
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
	
	public void addAnswer() {
		this.countOfAnswer += 1;
	}
	
	public void deleteAnswer() {
		this.countOfAnswer -= 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", countOfAnswer=" + countOfAnswer + ", createDate=" + createDate + ", answers=" + answers + "]";
	}


	
	
	
}
