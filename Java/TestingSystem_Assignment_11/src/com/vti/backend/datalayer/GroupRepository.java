package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Group;
import com.vti.ultis.JdbcUltis;

public class GroupRepository implements IGroupRepository {

	private JdbcUltis jdbc;

	public GroupRepository() throws FileNotFoundException, IOException {
		jdbc = new JdbcUltis();
	}
	
	public List<Group> getListGroups() throws ClassNotFoundException, SQLException {

		List<Group> groups = new ArrayList<>();
		// Create a statement object
		String sql = "SELECT * FROM `Group`";
		// execute query
		ResultSet resultSet = jdbc.executeQuery(sql);
		// handling result set
		while (resultSet.next()) {
			Group group = new Group(resultSet.getInt("GroupID"), resultSet.getString("GroupName"));
			groups.add(group);
		}
		jdbc.disConnection();
		return groups;
	}


}
