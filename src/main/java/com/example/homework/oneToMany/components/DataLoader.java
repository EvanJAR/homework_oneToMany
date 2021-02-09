package com.example.homework.oneToMany.components;

import com.example.homework.oneToMany.models.File;
import com.example.homework.oneToMany.models.Folder;
import com.example.homework.oneToMany.models.User;
import com.example.homework.oneToMany.repositories.FileRepository;
import com.example.homework.oneToMany.repositories.FolderRepository;
import com.example.homework.oneToMany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User evan = new User("Evan");
        userRepository.save(evan);

        Folder homeworks = new Folder("homework_folder", evan);
        folderRepository.save(homeworks);
        Folder week_13 = new Folder("week_13", evan);
        folderRepository.save(week_13);
        Folder week_14 = new Folder("week_14", evan);
        folderRepository.save(week_14);

        File oneToMany = new File("oneToMany", ".java", 3, homeworks);
        fileRepository.save(oneToMany);
        File newProject = new File("MovieApp", ".java", 4, homeworks);
        fileRepository.save(newProject);
        File python3 = new File("BetterSpotify", ".py", 4, week_13);
        fileRepository.save(python3);
        File javaProject = new File("pirates", ".java", 4, week_14);
        fileRepository.save(javaProject);
        File topSecretCode = new File("anon", ".txt", 980, week_14);
        fileRepository.save(topSecretCode);


    }
}
