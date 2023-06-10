package com.example.demo.Entity;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "vw_question_list")
public class QuestionListViewEntiry  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="question_id_pk")
	private Integer questionid;
	
	@Column(name="question_Description")
	private String questiondescription ;
	
	@Column(name="depart_id_fk")
	private Integer departmentID;
	
	@Column(name="depart_name")
	private String departmentName;
	
	@Column(name="subject_id_fk")
	private Integer subjectid;
	
	@Column(name="subject_name")
	private String subjectname;
	
	@Column(name="Terms_id_fk")
	private Integer termsid;
	
	@Column(name="Name")
	private String termsname;

	@Column(name="unit_id_fk")
	private Integer unitid;
	
	@Column(name="unit_name")
	private String unitname;
	
	@Column(name="difficulty_id_fk")
	private Integer difficultyid;
	
	@Column(name="difficulty_description")
	private String difficultydescription;
	
	@Column(name="ques_weight_id_fk")
	private Integer questionweightid;
	
	@Column(name="weight_age")
	private Integer questionweightage;
	
	@Column(name="IS_importent")
	private String isimportent;
	
	@Column(name="is_repeat")
	private String isrepeat;
	
	@Column(name="is_valid")
	private String isvalid;
	
	@Column(name="created_used_id_fk")
	private Integer createduserid;
	
	@Column(name="created_user_Name")
	private String createdusername;

	@Column(name="created_time_stamp")
	private String createdtimestamp;

	public QuestionListViewEntiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public QuestionListViewEntiry(Integer questionid, String questiondescription, Integer departmentID,
			String departmentName, Integer subjectid, String subjectname, Integer termsid, String termsname,
			Integer unitid, String unitname, Integer difficultyid, String difficultydescription,
			Integer questionweightid, Integer questionweightage, String isimportent, String isrepeat, String isvalid,
			Integer createduserid, String createdusername, String createdtimestamp) {
		super();
		this.questionid = questionid;
		this.questiondescription = questiondescription;
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.subjectid = subjectid;
		this.subjectname = subjectname;
		this.termsid = termsid;
		this.termsname = termsname;
		this.unitid = unitid;
		this.unitname = unitname;
		this.difficultyid = difficultyid;
		this.difficultydescription = difficultydescription;
		this.questionweightid = questionweightid;
		this.questionweightage = questionweightage;
		this.isimportent = isimportent;
		this.isrepeat = isrepeat;
		this.isvalid = isvalid;
		this.createduserid = createduserid;
		this.createdusername = createdusername;
		this.createdtimestamp = createdtimestamp;
	}


	public Integer getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	public String getQuestiondescription() {
		return questiondescription;
	}

	public void setQuestiondescription(String questiondescription) {
		this.questiondescription = questiondescription;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public Integer getTermsid() {
		return termsid;
	}

	public void setTermsid(Integer termsid) {
		this.termsid = termsid;
	}

	public String getTermsname() {
		return termsname;
	}

	public void setTermsname(String termsname) {
		this.termsname = termsname;
	}

	public Integer getUnitid() {
		return unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public Integer getDifficultyid() {
		return difficultyid;
	}

	public void setDifficultyid(Integer difficultyid) {
		this.difficultyid = difficultyid;
	}

	public String getDifficultydescription() {
		return difficultydescription;
	}

	public void setDifficultydescription(String difficultydescription) {
		this.difficultydescription = difficultydescription;
	}

	public Integer getQuestionweightid() {
		return questionweightid;
	}

	public void setQuestionweightid(Integer questionweightid) {
		this.questionweightid = questionweightid;
	}

	public Integer getQuestionweightage() {
		return questionweightage;
	}

	public void setQuestionweightage(Integer questionweightage) {
		this.questionweightage = questionweightage;
	}

	public String getIsimportent() {
		return isimportent;
	}

	public void setIsimportent(String isimportent) {
		this.isimportent = isimportent;
	}

	public String getIsrepeat() {
		return isrepeat;
	}

	public void setIsrepeat(String isrepeat) {
		this.isrepeat = isrepeat;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getCreateduserid() {
		return createduserid;
	}

	public void setCreateduserid(Integer createduserid) {
		this.createduserid = createduserid;
	}

	public String getCreatedusername() {
		return createdusername;
	}

	public void setCreatedusername(String createdusername) {
		this.createdusername = createdusername;
	}

	public String getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(String createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}
	
	
	
	
}

