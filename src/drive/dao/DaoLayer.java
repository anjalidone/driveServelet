package drive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import drive.beans.Drive;
import drive.beans.Loginpojo;
import drive.beans.Register;

public class DaoLayer {
	final static String dbDriver = "com.mysql.cj.jdbc.Driver";
	final static String dbURL = "jdbc:mysql://localhost:3306/track?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	final static String dbUsername = "root";
	final static String dbPassword = "root";

	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {

		Class.forName(dbDriver);

		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		return con;
	}

	public static Map<String, String> save(Drive cp) {

		Map<String, String> m = new HashMap<>();
		
		try (Connection con = DaoLayer.getDBConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into drive(COMPANY_NAME, NO_OF_RSRCS, EXP_REQ, CTC,JOIN_CRT,BOND, POSITION, FOLLOWUP, EDU_CRT,GST) values(?,?,?,?,?,?,?,?,?,?)");) 
		{

			ps.setObject(1, cp.getCompanyname());
			ps.setObject(2, cp.getResources());
			ps.setObject(3, cp.getExperience());
			ps.setObject(4, cp.getCtc());
			ps.setObject(5, cp.getCriteria());
			ps.setObject(6, cp.getBond());
			ps.setObject(7, cp.getPosition());
			ps.setObject(8, cp.getFollowup());
			ps.setObject(9, cp.getCriteria());
			ps.setObject(10, cp.getGst());
			
			int status = ps.executeUpdate();

			if (status == 1)
			{
				m.put("msg", "succesfully register");
			}
			else
			{
				m.put("msg", "error");
			}
		}
		catch (Exception e)
		{ }
		
		return m;
	}
	
	public static Map<String,String> login(Loginpojo log){
		Map<String,String> mp = new HashMap<String,String>();
		ResultSet status=null;
		try(Connection con = DaoLayer.getDBConnection();
		PreparedStatement ps = con.prepareStatement("select *from stud");)
		{
		status = ps.executeQuery();
		while (status.next()) {
			if (status.getString(3).equals(log.getEmail()) && status.getString(2).equals(log.getPass())) {
				mp.put("status", "user");
				break;
			}
			else {
				mp.put("status", "Error");
			}
		}

		System.out.println(mp);
		}
		catch( SQLException |ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return mp;
		
	}
	
	public static ArrayList<Drive> getUserDataFromDB(){
		
		ArrayList<Drive> al  = new ArrayList<>();
		try (Connection con = DaoLayer.getDBConnection();
				PreparedStatement ps = con.prepareStatement("select *from drive");ResultSet rs = ps.executeQuery();){
			while(rs.next()) {
				Drive cp = new Drive();
				cp.setDid(rs.getInt(1));
				cp.setCompanyname(rs.getString(2));
				cp.setResources(rs.getInt(3));
				cp.setExperience(rs.getInt(4));
				cp.setCtc(rs.getInt(5));
				cp.setBond(rs.getFloat(7));
				cp.setPosition(rs.getInt(8));
				cp.setFollowup(rs.getString(9));
				cp.setCriteria(rs.getInt(10));
				cp.setJoining(rs.getInt(6));
				cp.setGst(rs.getString(18));
				
				
				al.add(cp);
			}
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return al;
	
	}

public static Map<String, String> deleteEmpData(int d){
	Map<String, String> mp = new HashMap<>();
		
	try (Connection con = DaoLayer.getDBConnection();PreparedStatement ps =con.prepareStatement("delete from drive where DID=?;");)
	
	{
				
		ps.setObject(1,d);
		ps.executeUpdate();
		int status = ps.executeUpdate();

		

		if (status == 1) {
			mp.put("msg", "done");
		} else {
			mp.put("msg", "sorry");
		}
	}
	
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}

		return mp;

	}

	
	public static Map<String, String> update(Drive cp) {
		Map<String, String> m = new HashMap<>();
		 try (	Connection con = DaoLayer.getDBConnection();PreparedStatement ps = con.prepareStatement("update drive set COMPANY_NAME=?, NO_OF_RSRCS=?, EXP_REQ=?, CTC=?,JOIN_CRT=?,BOND=?, POSITION=?, FOLLOWUP=?, EDU_CRT=?,GST=? where did=?");
				 )
				 		 {
				 			     		
				 				ps.setObject(1, cp.getCompanyname());
				 				ps.setObject(2, cp.getResources());
				 				ps.setObject(3, cp.getExperience());
				 				ps.setObject(4, cp.getCtc());
				 				ps.setObject(5, cp.getCriteria());
				 				ps.setObject(6, cp.getBond());
				 				ps.setObject(7, cp.getPosition());
				 				ps.setObject(8, cp.getFollowup());
				 				ps.setObject(9, cp.getCriteria());
				 				ps.setObject(10,cp.getDid());
				 				ps.setObject(11,cp.getGst());
				 				

				 				int status = ps.executeUpdate();
				 				
				 				if (status == 1) 
				 				{
				 					m.put("msg", "succesfully updated");
				 				}  
				 				else 
				 				{
				 					m.put("msg", "error");
				 				}
					               
							 }
							 catch (ClassNotFoundException | SQLException e) {
									e.printStackTrace();
								
						}
						return m;
	}

	public static Map<String, String> saveData(Register rp)  {
		  Map<String, String> m = new HashMap<>();
		 
			try( Connection con = DaoLayer.getDBConnection();

				PreparedStatement ps = con.prepareStatement("insert into stud(name, pass, mail, gender, country, mobile) values(?,?,?,?,?,?)");)
			{
			    ps.setObject(1, rp.getName());
				ps.setObject(2, rp.getPass());
				ps.setObject(3, rp.getMail());
				ps.setObject(4, rp.getGender());
				ps.setObject(5, rp.getCountry());
				ps.setObject(6, rp.getMobile());
				

				int status = ps.executeUpdate();
				
				if (status == 1) 
				{
					m.put("msg", "succesfully register");
				}  
				else 
				{
					m.put("msg", "error");
				}
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
	               
		 return m;
		}
		
	}
	
	

