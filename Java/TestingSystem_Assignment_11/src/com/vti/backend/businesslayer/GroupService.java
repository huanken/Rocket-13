package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.GroupRepository;
import com.vti.backend.datalayer.IGroupRepository;
import com.vti.entity.Group;

public class GroupService implements IGroupService{
	private IGroupRepository repository;

	public GroupService() throws FileNotFoundException, IOException {
		repository = new GroupRepository();
	}

	public List<Group> getListGroups() throws ClassNotFoundException, SQLException {
//		To Do
		return repository.getListGroups();
	}
}
