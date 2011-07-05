package Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import Engine.Judge;
import Engine.Problem;
import Engine.UVA;

	
public class Test {
	public static String cookie, cuki;

	/**
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		// login2("OmarEl.Mohandes", "mmaw1234");
	//
//		login3();
	//	SIGN("OmarEl.Mohandes", "mmaw1234", new HttpClient());
		// Judge[] arr = {new UVA() , new SPOJ() , new Timus() , new
		// CodeForces() , new PKU()};
		// for(int i = 0 ; i < arr.length ; i ++)
		// generateProblemFile(arr[i] ,
		// arr[i].getClass().getSimpleName()+".txt");
		 UVA j = new UVA();
		// j.getLastSubmission("OmarEl.Mohandes", "mmaw1234");
		// try {
		// // j.submitProblem("omar_90", "OmarEl-Mohandes", "TEST", "17",
		// "ya raaaab");
		// // j.submitProblem("omar_90", "OmarEl-Mohandes", "TEST", "17",
		// "ya raaaab");
		// // j.submitProblem("omar_90", "OmarEl-Mohandes", "TEST", "17",
		// "ya raaaab");
		// // j.submitProblem("omar_90", "OmarEl-Mohandes", "TEST", "17",
		// "ya raaaab");
		// // // Submission s = j.getLastSubmission("107779JK", "");
		// // // System.out.println(s.getDate() + " " + s.getLanguage() + " " +
		// s.getProblemId() + " " + s.getStatus() + " " + s.getMemoryUsed() +
		// " " + s.getRuntime());
		// } catch (Exception e) {
		// // here is the exception.
		// e.printStackTrace();
		// }
	}

	public static void generateProblemFile(Judge j, String filename)
			throws Exception {
		PrintWriter p = new PrintWriter(new File(
				"/root/workspace/JudgesEngine/src/ProblemsFiles/" + filename));
		ArrayList<Problem> al = j.getAllProblems();
		System.out.println("Writting to a File ..");
		p.write("|		ID		|		NAME		|		URL		\n");
		for (int i = 0; i < al.size(); i++)
			p.write(al.get(i).getId() + " | " + al.get(i).getName() + " | "
					+ al.get(i).getUrl() + "\n");
		p.flush();
		p.close();
		System.out.println("Saved Successfully!");
	}

	@SuppressWarnings("unused")
	private static void login2(String username, String password)
			throws Exception {
		URL siteUrl = new URL(
				"http://uva.onlinejudge.org/index.php?option=com_comprofiler&task=login");
		HttpURLConnection conn = (HttpURLConnection) siteUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		out.writeBytes("");
		out.flush();
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StringBuilder s = new StringBuilder();
		String tem = "";
		while ((tem = in.readLine()) != null)
			s.append(tem + "\n");
		String reg = "<input type=\"hidden\" name=\"([\\s\\S]*?)\" value=\"([\\s\\S]*?)\" />";
		Matcher matcher = Pattern.compile(reg).matcher(s.toString());
		ArrayList<String> r1 = new ArrayList<String>();
		ArrayList<String> r2 = new ArrayList<String>();
		int number = 0;
		while (matcher.find()) {
			String name = matcher.group(1);
			String value = matcher.group(2);
			if (number > 0 && number < 9) {
				System.out.println(name + " = " + value);
				r1.add(name);
				r2.add(value);
			}
			++number;
		}
		String clot = "username=" + username + "&passwd=" + password
				+ "&remember=yes";
		for (int i = 0; i < r1.size(); i++) {
			clot += "&";
			clot += r1.get(i) + "=" + r2.get(i);
		}
		System.out.println(clot);
		conn.disconnect();
		conn = (HttpURLConnection) siteUrl.openConnection();
		// conn.connect();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		out = new DataOutputStream(conn.getOutputStream());
		out.writeBytes(clot);
		out.flush();
		out.close();
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		PrintWriter p = new PrintWriter(new File("remembertest.html"));
		while ((tem = in.readLine()) != null)
			p.write(tem + "\n");
		p.flush();
		p.close();

	}

}