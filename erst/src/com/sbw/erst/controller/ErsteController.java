package com.sbw.erst.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbw.erst.model.DBOperation;
import com.sbw.erst.model.Film;
import com.sbw.erst.model.User;

@Controller
public class ErsteController {
	private String userName;
	private static ErsteController ec = null;
	private ErsteController() {}
	public static ErsteController getInstance() {
		if (ec == null) {
			ec = new ErsteController();
		}
		return ec;
	}
	@RequestMapping("db.ha")
	public String db(String command, String param1, String param2, String param3, String param4, String param5, Map<String, String> map) {
		switch (command) {
		case "insertuser":
			if (DBOperation.getInstance().InsertUser(param1, param2, param3)) {
				map.put("hint", "妥了");
			} else {
				map.put("hint", "不可以，[用户名] [邮箱] [密码]");
			}
			break;
		case "insertfilm":
			if (DBOperation.getInstance().InsertFilm(param1, param2, Double.valueOf(param3).doubleValue())) {
				map.put("hint", "稳，稳极");
			} else {
				map.put("hint", "不可以，[电影名] [描述] [评分]");
			}
			break;
		case "queryuser":
			if (param1.length() <= 0) {
				map.put("hint", "不可以，[用户名]");
				break;
			}
			ArrayList<User> qalu = DBOperation.getInstance().QueryUserByUserName(param1);
			if (qalu.isEmpty()) {
				map.put("hint", "没这人");
				break;
			}
			map.put("hint", "ID:"+qalu.get(0).getUserID()+"\r\nuserName:"+qalu.get(0).getUserName()+"\r\nEmail:"+qalu.get(0).getEmail());
			break;
		case "queryfilm":
			if (param1.length() <= 0) {
				map.put("hint", "不可以，[电影名]");
				break;
			}
			ArrayList<Film> qalf = DBOperation.getInstance().QueryFilm(param1);
			if (qalf.isEmpty()) {
				map.put("hint", "没找着");
				break;
			}
			String message = "";
			for (int i = 0; i < qalf.size(); i++) {
				message += "ID:"+qalf.get(i).getFilmID();
				message += "\r\nfilmName:"+qalf.get(i).getFilmName();
				message += "\r\nDescription:"+qalf.get(i).getDescription();
				message += "\r\nRank:"+qalf.get(i).getRank();
			}
			map.put("hint", message);
			break;
		case "deleteuser":
			if (DBOperation.getInstance().DeleteUser(Integer.valueOf(param1).intValue())) {
				map.put("hint", "此人已从世界抹去");
			} else {
				map.put("hint", "压根儿没有");
			}
			break;
		case "deletefilm":
			if (DBOperation.getInstance().DeleteFilm(Integer.valueOf(param1).intValue())) {
				map.put("hint", "行了，没了");
			} else {
				map.put("hint", "没这片，再查查");
			}
			break;
		case "insertcinema":
			if (DBOperation.getInstance().InsertCinema(param1, param2, param3)) {
				map.put("hint", "加了");
			} else {
				map.put("hint", "不对，[影院名] [位置] [电话号]");
			}
			break;
		case "insertroom":
			if (DBOperation.getInstance().InsertRoom(Integer.valueOf(param1).intValue(), Integer.valueOf(param2).intValue(), param3, Integer.valueOf(param4).intValue(), Integer.valueOf(param5).intValue())) {
				map.put("hint", "加了");
			} else {
				map.put("hint", "不对，[房间ID] [影院ID] [房间名]");
			}
			break;
		case "insertsession":
			if (DBOperation.getInstance().InsertSession(Integer.valueOf(param1).intValue(), Integer.valueOf(param2).intValue(), param3, param4, Double.valueOf(param5).doubleValue())) {
				map.put("hint", "加了");
			} else {
				map.put("hint", "不对，[电影ID] [影院ID] [开始时间] [结束时间] [价格]");
			}
			break;
		default:
			map.put("hint", "不认识你那命令\r\n命令列表:\r\ninsertuser\r\ninsertfilm\r\nqueryuser\r\nqueryfilm\r\ndeleteuser\r\ndeletefilm\r\nexit");
			break;
		}
		return "../db";
	}
	@RequestMapping("login.ha")
	public String login() {
		return "login/login";
	}
	@RequestMapping("register.ha")
	public String register() {
		return "register/register";
	}
	@RequestMapping("registering.ha")
	public String registering(HttpServletRequest req) {
		String email = req.getParameter("email");
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		if (email.length() > 64) {
			req.setAttribute("registerWarning", "您的邮箱太长，不能注册！");
			return "register/register";
		}
		if (nickname.length() > 64) {
			req.setAttribute("registerWarning", "您的昵称太长！");
			return "register/register";
		}
		if (password.length() > 16 || password.length() < 6) {
			req.setAttribute("registerWarning", "密码长度应在6到16位之间！");
			return "register/register";
		}
		ArrayList<User> u = DBOperation.getInstance().QueryUserByEmail(email);
		if (!u.isEmpty()) {
			req.setAttribute("registerWarning", "该邮箱已经注册过了！");
			return "register/register";
		}
		u = DBOperation.getInstance().QueryUserByUserName(nickname);
		if (!u.isEmpty()) {
			req.setAttribute("registerWarning", "该昵称已经有人使用！");
			return "register/register";
		}
		DBOperation.getInstance().InsertUser(nickname, email, password);
		this.userName = nickname;
		ArrayList<Integer> fidl = DBOperation.getInstance().getThreeFilms();
		req.setAttribute("film1", fidl.get(0));
		req.setAttribute("film2", fidl.get(1));
		req.setAttribute("film3", fidl.get(2));
		req.setAttribute("userName", getInstance().userName);
		return "main/main";
	}
	@RequestMapping("logging.ha")
	public String logging(HttpServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if (email.length() > 64) {
			req.setAttribute("loginWarning", "您的邮箱太长！");
			return "login/login";
		}
		ArrayList<User> u = DBOperation.getInstance().QueryUserByEmail(email);
		if (u.isEmpty()) {
			req.setAttribute("loginWarning", "账号不存在！");
			return "login/login";
		}
		if (password.length() > 16 || password.length() < 6) {
			req.setAttribute("loginWarning", "密码长度应在6到16位之间！");
			return "login/login";
	 	}
		User user = u.get(0);
		if (!password.equals(user.getPassWord())) {
			req.setAttribute("loginWarning", "密码错误！");
			return "login/login";
		}
		getInstance().userName = user.getUserName();
		ArrayList<Integer> fidl = DBOperation.getInstance().getThreeFilms();
		req.setAttribute("film1", fidl.get(0));
		req.setAttribute("film2", fidl.get(1));
		req.setAttribute("film3", fidl.get(2));
		req.setAttribute("userName", getInstance().userName);
		return "main/main";
	}
	@RequestMapping("search.ha")
	public String search(HttpServletRequest req) {
		String fname = req.getParameter("movieName");
		ArrayList<Film> flist = DBOperation.getInstance().QueryFilm(fname);
		req.setAttribute("filmList", flist);
		req.setAttribute("userName", getInstance().userName);
		return "search/search";
	}
	@RequestMapping("info.ha")
	public String movieInfo(HttpServletRequest req) {
		Film f = DBOperation.getInstance().QueryFilm(Integer.valueOf(req.getParameter("filmid")).intValue()).get(0);
		String pic = "images/"+f.getFilmID()+".jpg";
		req.setAttribute("pic", pic);
		req.setAttribute("filmID", f.getFilmID());
		req.setAttribute("movieName", f.getFilmName());
		req.setAttribute("movieDescription", f.getDescription());
		req.setAttribute("movieRank", Double.valueOf(f.getRank()).toString());
		req.setAttribute("userName", getInstance().userName);
		return "movieinfo/movieinfo";
	}
	@RequestMapping("selkino.ha")
	public String selectCinema(HttpServletRequest req) {
		ArrayList<Integer> alsid = DBOperation.getInstance().getAllSession(Integer.valueOf(req.getParameter("filmid")).intValue());
		req.setAttribute("sessions", alsid);
		req.setAttribute("userName", getInstance().userName);
		return "cinemas/cinemas";
	}
	@RequestMapping("selseat.ha")
	public String selectSeat(HttpServletRequest req) {
		int sid = Integer.valueOf(req.getParameter("sessionid")).intValue();
		req.setAttribute("sessionid", sid);
		req.setAttribute("userName", getInstance().userName);
		return "seats/seats";
	}
	@RequestMapping("reservation.ha")
	public String reservation(HttpServletRequest req) {
		int seatid = Integer.valueOf(req.getParameter("seatid")).intValue();
		int sessionid = Integer.valueOf(req.getParameter("sessionid")).intValue();
		req.setAttribute("userName", getInstance().userName);
		req.setAttribute("seatid", seatid);
		req.setAttribute("sessionid", sessionid);
		return "reservation/reservation";
	}
	@RequestMapping("payment.ha")
	public String payment(HttpServletRequest req) {
		int seatid = Integer.valueOf(req.getParameter("seatid")).intValue();
		int sessionid = Integer.valueOf(req.getParameter("sessionid")).intValue();
		int userid = DBOperation.getInstance().QueryUserByUserName(getInstance().userName).get(0).getUserID();
		DBOperation.getInstance().InsertReservation(userid, seatid, sessionid);
		req.setAttribute("userName", getInstance().userName);
		return "payment/payment";
	}
	@RequestMapping("return.ha")
	public String returnMain(HttpServletRequest req) {
		ArrayList<Integer> fidl = DBOperation.getInstance().getThreeFilms();
		req.setAttribute("film1", fidl.get(0));
		req.setAttribute("film2", fidl.get(1));
		req.setAttribute("film3", fidl.get(2));
		req.setAttribute("userName", getInstance().userName);
		return "main/main";
	}
	public String getUserName() {
		return getInstance().userName;
	}
	public void setUserName(String userName) {
		getInstance().userName = userName;
	}
}