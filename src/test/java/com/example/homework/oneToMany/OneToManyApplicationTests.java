package com.example.homework.oneToMany;

import com.example.homework.oneToMany.models.File;
import com.example.homework.oneToMany.models.Folder;
import com.example.homework.oneToMany.models.User;
import com.example.homework.oneToMany.repositories.FileRepository;
import com.example.homework.oneToMany.repositories.FolderRepository;
import com.example.homework.oneToMany.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToManyApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSaveUsersFilesFolders(){


	User john = new User("John");
	userRepository.save(john);

	Folder homeworks = new Folder("homework_folder", john);
	folderRepository.save(homeworks);

	File oneToMany = new File("oneToMany", ".java", 3, homeworks);
	fileRepository.save(oneToMany);

	}
}
