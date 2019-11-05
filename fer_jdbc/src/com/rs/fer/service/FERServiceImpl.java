package com.rs.fer.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertContentAction;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService{

	@Override
	public boolean registration(User user) {
		
		boolean isRegister = false;
		
		Connection connection =null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtil.getConnection();
			
			String sql="INSERT INTO USER(username,PASSWORD,firstname,lastname,mobile,email, middlename)VALUES(?,?,?,?,?,?,?);";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getMobile());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getMiddleName());
			
			int insertedCount = statement.executeUpdate();
			
			isRegister = insertedCount > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}

		
		return isRegister;
	}

	@Override
	public boolean login(String username, String password) {
		boolean isLogin = false;
		
		Connection connection =null;
		PreparedStatement statement = null;
		
		try {
			connection = DBUtil.getConnection();
			
			String sql="SELECT username,password from user where username=? and password=?";
			statement=connection.prepareStatement(sql);			
			statement.setString(1,"divya");
			statement.setString(2, "divya123");		   
			
			ResultSet insertedCount = statement.executeQuery();
			
			if(insertedCount.next()) {
				//System.out.println("Records  fetched successfully..");
				isLogin = true;
			}else {
				System.out.println("no matched records..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}

		
		return isLogin;
	}

	@Override
	public boolean addExpense(Expense expense) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int expensesEdited = 0;
		try {
			connection = DBUtil.getConnection();
			String inputQuery = "Insert into expense(eid,date,price,no_of_items,total,bywhom,type)values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(inputQuery);
			preparedStatement.setInt(1, expense.getId());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setInt(3, (int) expense.getPrice());
			preparedStatement.setInt(4, expense.getNumberOfItems());
			preparedStatement.setInt(5, (int) expense.getTotal());
			preparedStatement.setString(6, expense.getByWhom());
			preparedStatement.setString(7, expense.getType());
			
			expensesEdited = preparedStatement.executeUpdate();
			System.out.println(expense.getType() + ", " + expense.getDate() + ", " + expense.getPrice() + ", "
					+ expense.getNumberOfItems() + ", " + expense.getTotal() + ", " + expense.getByWhom() + ", "
					+ expense.getId());
			System.out.println(expensesEdited + " Expense Record is Insertd");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expensesEdited > 0;
	
	}

	@Override
	public boolean editExpense(Expense expense) {


		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int expensesEdited = 0;
		try {
			connection = DBUtil.getConnection();
			String inputQuery = "update expense set type=?, date=?, price=?, no_of_items=?, total=?, bywhom=? where eid=?";
			preparedStatement = connection.prepareStatement(inputQuery);
			preparedStatement.setString(1, expense.getType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNumberOfItems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getByWhom());
			preparedStatement.setInt(7, expense.getId());

			expensesEdited = preparedStatement.executeUpdate();
			System.out.println(expense.getType() + ", " + expense.getDate() + ", " + expense.getPrice() + ", "
					+ expense.getNumberOfItems() + ", " + expense.getTotal() + ", " + expense.getByWhom() + ", "
					+ expense.getId());
			System.out.println(expensesEdited + " Expense Record is Edited");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expensesEdited > 0;
	}

	@Override
	public boolean deleteExpense(int expenseId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int expensesDeleted = 0;
		try {
			connection = DBUtil.getConnection();

			String inputQuery = "delete from expense where eid=?";

			preparedStatement = connection.prepareStatement(inputQuery);
			preparedStatement.setInt(1, expenseId);
			expensesDeleted = preparedStatement.executeUpdate();
			System.out.println(expenseId + " is Deleted");
			System.out.println(expensesDeleted + " Expense Record is Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expensesDeleted > 0;
	}


	@Override
	public Expense getExpense(int expenseId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Expense expense = new Expense();

		try {
			connection = DBUtil.getConnection();
			String inputQuery = "select * from expense where eid = ?";
			preparedStatement = connection.prepareStatement(inputQuery);
			preparedStatement.setInt(1, expenseId);

			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet + " Expense Report is Fetched");

		
			while (resultSet.next()) {
			expense = new Expense();

				expense.setType(resultSet.getString("eid"));
				expense.setType(resultSet.getString("type"));
				expense.setType(resultSet.getString("date"));
				expense.setType(resultSet.getString("price"));
				expense.setType(resultSet.getString("no_of_items"));
				expense.setType(resultSet.getString("total"));
				expense.setType(resultSet.getString("bywhom"));

				//expenses.add(expense);
				System.out.println(resultSet.getInt("eid") + ", " + resultSet.getString("type") + ", "
						+ resultSet.getString("date") + ", " + resultSet.getString("no_of_items") + ", "
						+ resultSet.getString("price") + ", " + resultSet.getString("bywhom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;

	}

	@Override
	public List<Expense> getExpenses(int userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Expense> expenses = new ArrayList<Expense>();

		try {
			connection = DBUtil.getConnection();
			String inputQuery = "select * from expense";
			preparedStatement = connection.prepareStatement(inputQuery);

			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet + " Expense Report is Fetched");

		
			Expense expense = new Expense();
			
			while (resultSet.next()) {
				expense = new Expense();

				expense.setType(resultSet.getString("eid"));
				expense.setType(resultSet.getString("type"));
				expense.setType(resultSet.getString("date"));
				expense.setType(resultSet.getString("price"));
				expense.setType(resultSet.getString("no_of_items"));
				expense.setType(resultSet.getString("total"));
				expense.setType(resultSet.getString("bywhom"));

				expenses.add(expense);
				System.out.println(resultSet.getInt("eid") + ", " + resultSet.getString("type") + ", "
						+ resultSet.getString("date") + ", " + resultSet.getString("no_of_items") + ", "
						+ resultSet.getString("price") + ", " + resultSet.getString("bywhom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;

	
	}

	@Override
	public List<Expense> expenseReport(  String expenseType, String fromDate, String toDate) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			List<Expense> expenseReport = new ArrayList<Expense>();
			try {
				connection = DBUtil.getConnection();
				String inputQuery = "select * from expense where type = ? and date between ? and ?";
				preparedStatement = connection.prepareStatement(inputQuery);
				preparedStatement.setString(1, expenseType);
				preparedStatement.setString(2, fromDate);
				preparedStatement.setString(3, toDate);

				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println(resultSet + " Record is Fetched");
				Expense expense = new Expense();
				while (resultSet.next()) {
					
					expense.setId(resultSet.getInt("eid"));
					expense.setType(resultSet.getString("type"));
					expense.setDate(resultSet.getString("date"));
					expense.setNumberOfItems(resultSet.getInt("no_of_items"));
					expense.setPrice(resultSet.getInt("price"));
					expense.setByWhom(resultSet.getString("bywhom"));
					expense.setUserId(resultSet.getInt("userid"));
					expenseReport.add(expense);
					
					
					System.out.println(resultSet.getInt("eid") + ", " + resultSet.getString("type") + ", "
							+ resultSet.getString("date") + ", " + resultSet.getString("no_of_items") + ", "
							+ resultSet.getString("price") + ", " + resultSet.getString("bywhom") + ", "
							+ resultSet.getInt("userid"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConnection(connection);
			}
			return expenseReport;
	}
	

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int resetPassword = 0;
		try {
			connection = DBUtil.getConnection();
			String inputQuery = "update user set password=? where id=? and password=?";
			preparedStatement = connection.prepareStatement(inputQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, currentPassword);
			preparedStatement.setString(3, newPassword);

			resetPassword = preparedStatement.executeUpdate();
			System.out.println(resetPassword + " Record is Updated");
			System.out.println(newPassword + ", " + userId + ", " + currentPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return resetPassword > 0;
	}
	
	@Override
	public User getPersonal(int userId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		User user = new User();

		try {
			connection = DBUtil.getConnection();
			String inputQuery = "select u.*,a.* from user u left join address a on u.id = a.userid where a.userid=?";
			preparedStatement = connection.prepareStatement(inputQuery);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setMiddleName(resultSet.getString("middlename"));
				user.setLastName(resultSet.getString("lastname"));
				user.setMobile(resultSet.getString("mobile"));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));

				Address address = new Address();
				address.setId(resultSet.getInt("userid"));
				address.setLineOne(resultSet.getString("line1"));
				address.setLineTwo(resultSet.getString("line2"));
				address.setCity(resultSet.getString("city"));
				address.setState(resultSet.getString("country"));
				address.setZip(resultSet.getString("zip"));

				user.setAddress(address);
				System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("firstname") + ", "
						+ resultSet.getString("middlename") + ", " + resultSet.getString("lastname") + ", "
						+ resultSet.getString("mobile") + ", " + resultSet.getString("email") + ", "
						+ resultSet.getString("username") + ", " + resultSet.getString("password") + ", "
						+ resultSet.getInt("userid") + ", " + resultSet.getString("line1") + ", "
						+ resultSet.getString("line2") +  ", "
						+ resultSet.getString("city") + ", " + resultSet.getString("country") + ", "
						+ resultSet.getString("zip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return user;
	}

	
			@Override
	public boolean updatePersonal(User user) {

				Connection connection = null;
				PreparedStatement preparedStatement = null;
				int updateUser = 0;
				boolean isUpdate = true;
				try {
					connection = DBUtil.getConnection();

					// Update User
					String inputQuery = "update user set firstname=?, middlename=?, lastname=?, email=?, mobile=? where id=?";
					preparedStatement = connection.prepareStatement(inputQuery);
					preparedStatement.setString(1, user.getFirstName());
					preparedStatement.setString(2, user.getMiddleName());
					preparedStatement.setString(3, user.getLastName());
					preparedStatement.setString(4, user.getEmail());
					preparedStatement.setString(5, user.getMobile());
					preparedStatement.setInt(6, user.getId());

					updateUser = preparedStatement.executeUpdate();
					System.out.println(updateUser + " User Record is Updated");

					Address address = user.getAddress();
					String inputAddress = "";
					if (updateUser > 0) {
						if (address.getId() == 0) {
							inputAddress = "insert into address(line1, line2, street, city, state, zip,id) values(?,?,?,?,?,?,?)";
						} else {
							inputAddress = "update address set line1=?, line2=?, city=?, state=?,country=?,zip=? where id=?";
						}
						preparedStatement = connection.prepareStatement(inputAddress);
						preparedStatement.setString(1, address.getLineOne());
						preparedStatement.setString(2, address.getLineTwo());
						preparedStatement.setString(3, address.getState());
						preparedStatement.setString(4, address.getCity());
						preparedStatement.setString(5, address.getCountry());
						preparedStatement.setString(6, address.getZip());
						preparedStatement.setInt(7, address.getId());

						int addressRegistered = preparedStatement.executeUpdate();
						System.out.println(addressRegistered + " Address Record is Updated");
						isUpdate = addressRegistered > 0;
						System.out.println(user.getId() + ", " + user.getFirstName() + ", " + user.getMiddleName() + ", "
								+ user.getLastName() + ", " + user.getMobile() + ", " + user.getEmail() + ", "
								+ user.getUsername() + ", " + user.getPassword() + ", " + address.getId() + ", "
								+ address.getLineOne() + ", " + address.getLineTwo() + ", " + address.getCountry()
								+ ", " + address.getCity() + ", " + address.getState() + ", " + address.getZip() + ", "
								+ address.getId());

					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.closeConnection(connection);
				}
				return isUpdate;

			}

			
		
	}


