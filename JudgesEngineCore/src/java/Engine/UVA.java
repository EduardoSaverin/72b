package Engine;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class UVA implements Judge {

	private ArrayList<String> getResponse(String url, String request)
			throws Exception {
		URL siteUrl = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) siteUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		out.writeBytes(request);
		out.flush();
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String tem = "";
		StringBuilder page = new StringBuilder();
		while ((tem = in.readLine()) != null)
			page.append(tem + "\n");
		in.close();
		conn.disconnect();
		Matcher m = Pattern.compile("<body>\\s*O_O([\\s\\S]*)O_O\\s*</body>")
				.matcher(page);
		m.find();
		String a = m.group(1);
		StringTokenizer s = new StringTokenizer(a, "|");
		ArrayList<String> ret = new ArrayList<String>();
		while (s.countTokens() != 0)
			ret.add(s.nextToken());
		return ret;
	}

	@Override
	public boolean signIn(String username, String password) throws Exception {
		ArrayList<String> ret = getResponse(
				"http://wahab.homeip.net:8080/JudgesEngineCore/index.jsp",
				"username=" + username + "&password=" + password
						+ "&ID=1&JID=UVA");
		return Boolean.parseBoolean(ret.get(0));
	}

	private ArrayList<String> getVolumes() throws HttpException, IOException {
		throw new UnsupportedOperationException(
				"This function not implemented yet!");

	}

	@Override
	public ArrayList<Problem> getAllProblems() throws HttpException,
			IOException {
		throw new UnsupportedOperationException(
				"This function not implemented yet!");

	}

	@Override
	public Submission getLastSubmission(String coderId, String password)
			throws Exception {
		ArrayList<String> a = getResponse(
				"http://wahab.homeip.net:8080/JudgesEngineCore/index.jsp",
				"username=" + coderId + "&password=" + password
						+ "&ID=4&JID=UVA");
		return new Submission(a.get(0), a.get(5), a.get(1), a.get(2), a.get(3),
				a.get(4));
	}

	@Override
	public Problem getProblemInfo(String problemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getProblemsSolved(String coderId) {

		return null;
	}

	/*
	 * Value --> language
	 *  1 --> ANSI C 4.1.2 - GNU C Compiler with options: -lm  -lcrypt -O2 -pipe -ansi -DONLINE_JUDGE 
	 *  2 --> JAVA 1.6.0 - Java Sun JDK 
	 *  3 --> C++ 4.1.2 - GNU C++ Compiler with options: -lm -lcrypt -O2 -pipe -DONLINE_JUDGE 
	 *  4 --> PASCAL 2.0.4 - Free Pascal Compiler (non-Javadoc)
	 * @see Engine.Judge#submitProblem(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void submitProblem(String coderId, String password,
			String problemId, String language, String code) throws Exception {
		getResponse("http://wahab.homeip.net:8080/JudgesEngineCore/index.jsp",
				"coderId=" + coderId + "&password=" + password + "&problemId="
						+ problemId + "&languageId=" + language + "&code=" + code + "&ID=3&JID=UVA");
	}

	@Override
	public boolean signOut(String username) {
		return true;
	}

	@Override
	public ArrayList<ProblemText> getProblemTexts(String filePath)
			throws Exception {
		throw new UnsupportedOperationException(
				"This function not implemented yet!");
	}
}
