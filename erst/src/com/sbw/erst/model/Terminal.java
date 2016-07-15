package com.sbw.erst.model;
import java.util.*;

public class Terminal {
	private static String command;
	private static DBOperation db = DBOperation.getInstance();
	public static void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("命令列表:\r\ninsertuser\r\ninsertfilm\r\nqueryuser\r\nqueryfilm\r\ndeleteuser\r\ndeletefilm\r\nexit");
		while ((command = sc.nextLine()) != "exit")	{
			switch (command) {
			case "insertuser":
				System.out.println("[username] [email] [password]");
				String username, email, password;
				username = sc.next();
				email = sc.next();
				password = sc.next();
				db.InsertUser(username, email, password);
				break;
			case "insertfilm":
				System.out.println("[filmname] [description] [rank]");
				String filmname, description;
				double rank;
				filmname = sc.next();
				description = sc.next();
				rank = sc.nextDouble();
				db.InsertFilm(filmname, description, rank);
				break;
			case "queryuser":
				System.out.println("[username]");
				String qusername = sc.nextLine();
				ArrayList<User> qalu = db.QueryUserByUserName(qusername);
				if (qalu.isEmpty()) {
					System.out.println("Not found");
					break;
				}
				System.out.println("ID:"+qalu.get(0).getUserID());
				System.out.println("userName:"+qalu.get(0).getUserName());
				System.out.println("Email:"+qalu.get(0).getEmail());
				break;
			case "queryfilm":
				System.out.println("[filmname]");
				String qfilmname = sc.nextLine();
				ArrayList<Film> qalf = db.QueryFilm(qfilmname);
				if (qalf.isEmpty()) {
					System.out.println("Not found");
					break;
				}
				for (int i = 0; i < qalf.size(); i++) {
					System.out.println("ID:"+qalf.get(i).getFilmID());
					System.out.println("filmName:"+qalf.get(i).getFilmName());
					System.out.println("Description:"+qalf.get(i).getDescription());
					System.out.println("Rank:"+qalf.get(i).getRank());
				}
				break;
			case "deleteuser":
				System.out.println("[userid]");
				int duid = sc.nextInt();
				if (db.DeleteUser(duid)) {
					System.out.println("Done.");
				} else {
					System.out.println("Not found");
				}
				break;
			case "deletefilm":
				System.out.println("[filmid]");
				int dfid = sc.nextInt();
				if (db.DeleteFilm(dfid)) {
					System.out.println("Done.");
				} else {
					System.out.println("Not found");
				}
				break;
			default:
				System.out.println("Not a command!");
				break;
			}
		}
		sc.close();
	}
}
