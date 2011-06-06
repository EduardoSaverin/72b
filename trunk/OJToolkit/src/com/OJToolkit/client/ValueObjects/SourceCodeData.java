package com.OJToolkit.client.ValueObjects;

/**
 * @author magdi
 *
 */
public class SourceCodeData {
	private Long codeID;
	private Long userID;
	private String problemCode;
	private String problemName;
	private String url;
	private String code;
	private String note;
	private String judgeResult;
	private String date;
	
	/**
	 * @param codeID
	 * @param userID
	 * @param problemCode
	 * @param problemName
	 * @param url
	 * @param code
	 * @param note
	 * @param judgeResult
	 * @param date
	 */
	public SourceCodeData(Long codeID, Long userID, String problemCode,
			String problemName, String url, String code, String note,
			String judgeResult, String date) {
		super();
		this.codeID = codeID;
		this.userID = userID;
		this.problemCode = problemCode;
		this.problemName = problemName;
		this.url = url;
		this.code = code;
		this.note = note;
		this.judgeResult = judgeResult;
		this.date = date;
	}
	/**
	 * @return
	 */
	public Long getCodeID() {
		return codeID;
	}
	/**
	 * @param codeID
	 */
	public void setCodeID(Long codeID) {
		this.codeID = codeID;
	}
	/**
	 * @return
	 */
	public Long getUserID() {
		return userID;
	}
	/**
	 * @param userID
	 */
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	/**
	 * @return
	 */
	public String getProblemCode() {
		return problemCode;
	}
	/**
	 * @param problemCode
	 */
	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}
	/**
	 * @return
	 */
	public String getProblemName() {
		return problemName;
	}
	/**
	 * @param problemName
	 */
	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}
	/**
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return
	 */
	public String getJudgeResult() {
		return judgeResult;
	}
	/**
	 * @param judgeResult
	 */
	public void setJudgeResult(String judgeResult) {
		this.judgeResult = judgeResult;
	}
	/**
	 * @return
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
